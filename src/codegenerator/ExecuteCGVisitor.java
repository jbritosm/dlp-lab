package codegenerator;

import ast.astnode.Program;
import ast.definition.FunctionDefinition;
import ast.definition.VariableDefinition;
import ast.functioninvocation.FunctionInvocation;
import ast.statement.*;
import ast.type.FunctionType;
import ast.type.VoidType;

import java.util.ArrayList;
import java.util.List;

public class ExecuteCGVisitor extends AbstractCGVisitor<Object, Void>{

    private AddressCGVisitor addressCGVisitor;
    private ValueCGVisitor valueCGVisitor;
    public ExecuteCGVisitor(CodeGenerator cg) {
        super(cg);

        addressCGVisitor = new AddressCGVisitor(cg);
        valueCGVisitor = new ValueCGVisitor(cg);

        addressCGVisitor.setValueCGVisitor(valueCGVisitor);
        valueCGVisitor.setAddressCGVisitor(addressCGVisitor);
    }

    /**
     *  execute[[Program : program -> definition*]]() =
     *      for(Definition definition : definition*)
     *          if(definition instanceof VariableDefinition)
     *              execute[[definition]]()
     *      <call main>
     *      <halt>
     *
     *      for(Definition definition : definition*)
     *          if(definition instanceof FunctionDefinition)
     *              execute[[definition]]()
     */
    @Override
    public Void visit(Program program, Object parameter) {
        program.getDefinitions().forEach(definition -> {
            if(definition instanceof VariableDefinition) definition.accept(this, parameter);
        });

        cg.comment("Invocation to the main function");
        cg.call("main");
        cg.halt();

        cg.newLine();

        program.getDefinitions().forEach(definition -> {
            if(definition instanceof FunctionDefinition) definition.accept(this, parameter);
        });
        cg.close();

        cg.newLine();
        return null;
    }

    /**
     * execute[[FunctionDefinition : definition1 -> type ID variableDefinition* statement*]]() = {
     *     ID <:>
     *
     *     <' * Locals>
     *     variableDefinition*.stream().forEach(variableDefinition -> execute[[variableDefinition]])
     *     int localVariableBytes = variableDefinition*.get(variableDefinition*.size() - 1)
     *
     *     <enter> localVariableBytes
     *
     *
     *     int argumentBytes
     *     // Type is casted to FunctionType: type -> functionType
     *     functionType.arguments.forEach(variableDefinition -> argumentBytes += variableDefinition.offset)
     *
     *     <enter> argumentBytes
     *
     *     int returnBytes = functionType.returnType.numberOfBytes
     *     statement*.stream().forEach(statement -> execute[[statement]])
     *
     *     if(functionType instanceof VoidType)
     *          <ret> returnBytes, localVariableBytes, argumentBytes
     *
     */
    @Override
    public Void visit(FunctionDefinition functionDefinition, Object parameter) {
        cg.line(functionDefinition.getLine());
        cg.newLine();
        // Set label of the function
        cg.label(functionDefinition.getName());

        // Cast type of the function definition to function type in order to perform some
        // operations.
        FunctionType functionType = (FunctionType) functionDefinition.getType();

        // Comment all the function parameters in order to check everything is working
        // as intended.
        cg.comment("Parameters");
        functionType.getArguments().forEach(variableDefinition -> variableDefinition.accept(this, parameter));
        // Get bytes of the parameters
        int argumentBytes = functionDefinition.argumentsNumberOfBytes();

        // Lists to store definitions of local variables and the rest of the statements to perform
        // operations later.
        List<VariableDefinition> variableDefinitionList = new ArrayList<>();
        List<Statement> statementList = new ArrayList<>();

        functionDefinition.getStatements().forEach(statement -> {
            if(statement instanceof VariableDefinition)
                variableDefinitionList.add((VariableDefinition) statement);
            else
                statementList.add(statement);
        });

        cg.comment("Local variables");
        // Execute local variables of the function
        variableDefinitionList.forEach(variableDefinition -> variableDefinition.accept(this, parameter));
        // Get bytes of local variables
        int localVariableBytes = functionDefinition.localsNumberOfBytes();
        cg.enter(localVariableBytes);

        // Execute each non variable definition statement in the function body passing as parameter
        // the function definition in order for all the statements to know the returnType of the
        // function.
        if(!statementList.isEmpty()) {
            cg.newLine();
            cg.line(statementList.get(0).getLine());
        }

        statementList.forEach(statement -> statement.accept(this, functionDefinition));

        // Get bytes of the returnType of the function.
        int returnBytes = functionType.getReturnType().numberOfBytes();

        // If the function is void it wont have a return statement, therefore we need to
        // add one in order for it to return when invoked.
        if(functionType.getReturnType() instanceof VoidType) {
            cg.ret(returnBytes, localVariableBytes, argumentBytes);
        }

        cg.newLine();
        return null;
    }

    /**
     *  execute[[VariableDefinition: definition -> type ID]]() = {
     *      <' *> type.toString() definition.getName (offset definition.offset)
     *  }
     */
    @Override
    public Void visit(VariableDefinition variableDefinition, Object parameter) {
        cg.comment(String.format("%s %s (offset %d)", variableDefinition.getType().getTypeExpression()
                                                    , variableDefinition.getName()
                                                    , variableDefinition.getOffset()));

        return null;
    }

    /**
     *  execute[[AssignmentStatement : assignment -> expression1 expression2]]() =
     *      address[[expression1]]
     *      value[[expression2]]
     *      <store> expression1.type.suffix()
     */
    @Override
    public Void visit(AssignmentStatement assignmentStatement, Object parameter) {
        cg.comment("Assignment");
        assignmentStatement.getLeft().accept(addressCGVisitor, parameter);
        assignmentStatement.getRight().accept(valueCGVisitor, parameter);
        cg.store(assignmentStatement.getLeft().getType().getSuffix());

        cg.newLine();
        return null;
    }

    /**
     * execute[[Print : statement -> expression]]() =
     *     value[[expression]]()
     *     <out> expression.type.suffix()
    */
    @Override
    public Void visit(PrintStatement printStatement, Object parameter) {
        cg.comment("Print");
        printStatement.getPrintExpressions().forEach(expression -> {
            expression.accept(valueCGVisitor, parameter);
            cg.out(expression.getType().getSuffix());}
        );

        cg.newLine();
        return null;
    }

    /**
     * execute[[Input : statement -> expression]]() =
     *     address[[expression]]()
     *     <in> expression.type.suffix()
     *     <store> expression.type.suffix()
     */
    @Override
    public Void visit(ReadStatement readStatement, Object parameter) {
        cg.comment("Read");
        readStatement.getReadExpressions().forEach(expression -> {
            expression.accept(addressCGVisitor, parameter);
            cg.in(expression.getType().getSuffix());
            cg.store(expression.getType().getSuffix());
        });

        cg.newLine();
        return null;
    }


    /**
     * execute[[FunctionInvocation : statement -> expression1 expression2*]]() = {
     *     expression2*.stream().forEach(expression -> value[[expression]])
     *     <call> expression1.name
     * }
     */
    @Override
    public Void visit(FunctionInvocation functionInvocation, Object parameter) {
        cg.comment("Function Invocation");
        functionInvocation.getArguments().forEach(expression -> expression.accept(valueCGVisitor, parameter));
        cg.call(functionInvocation.getVariableExpression().getName());

        cg.newLine();
        return null;
    }

    /**
     * execute[[IfElseStatement : statement -> expression statement1+ statement2*]]() = {
     *     value[[expression]]
     *
     *     <jz> elseBody
     *     statement1+.stream.forEach(statement -> execute[[statement]])
     *     <jmp> exitIf
     *     elseBody <:>
     *     statement2*.stream.forEach(statement -> execute[[statement]])
     *     exitIf <:>
     *}
     */
    @Override
    public Void visit(IfElseStatement ifElseStatement, Object parameter) {
        cg.comment("IfElse");
        String elseBody = cg.nextLabel();
        String exitIf = cg.nextLabel();

        ifElseStatement.getCondition().accept(valueCGVisitor, parameter);
        cg.jz(elseBody);
        // Execute if
        ifElseStatement.getIfBody().forEach(statement -> statement.accept(this, parameter));
        cg.jmp(exitIf);
        // Execute else
        cg.label(elseBody);
        ifElseStatement.getElseBody().forEach(statement -> statement.accept(this, parameter));
        cg.label(exitIf);

        cg.newLine();
        return null;
    }

    /**
     * execute[[ReturnStatement : statement -> expression]](functionDefinition) = {
     *      value[[expression]]
     *
     *      <ret>   expression.type.numberOfBytes(),
     *              functionDefinition.getBytesOfLocals(),
     *              ((FunctionType)functionDefinition.getType()).getBytesOfParams();
     *
     * }
     */
    @Override
    public Void visit(ReturnStatement returnStatement, Object parameter) {
        cg.comment("Return");
        returnStatement.getReturnExpression().accept(valueCGVisitor, parameter);
        FunctionDefinition functionDefinition = (FunctionDefinition) parameter;


        int retBytes = returnStatement.getReturnExpression().getType().numberOfBytes();
        int localsBytes = functionDefinition.localsNumberOfBytes();
        int argumentsBytes = functionDefinition.argumentsNumberOfBytes();

        cg.ret(retBytes, localsBytes, argumentsBytes);

        cg.newLine();
        return null;
    }

    /**
     * execute[[WhileStatement : statement -> expression statement*]]() = {
     *      String enterLoop = cg.label()
     *      String exitLoop = cg.label()
     *
     *
     *     enterLoop <:>
     *     value[[expression]]
     *     <jz> exitLoop
     *     statement*.stream().forEach(statement -> execute[[statement]])
     *     <jmp> enterLoop
     *     exitLoop <:>
     * }
     */
    @Override
    public Void visit(WhileStatement whileStatement, Object parameter) {
        cg.comment("While");
        String enterLoop = cg.nextLabel();
        String exitLoop = cg.nextLabel();


        cg.label(enterLoop);
        whileStatement.getCondition().accept(valueCGVisitor, parameter);
        cg.jz(exitLoop);
        whileStatement.getBody().forEach(statement -> statement.accept(this, parameter));
        cg.jmp(enterLoop);
        cg.label(exitLoop);

        cg.newLine();
        return null;
    }
}
