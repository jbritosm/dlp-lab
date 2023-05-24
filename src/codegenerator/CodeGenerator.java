package codegenerator;

import java.io.*;

public class CodeGenerator {

    private PrintWriter out;
    private String input;
    private String output;
    private int labelCounter;

    public CodeGenerator(String output, String input) {

        labelCounter = 0;

        try {
            this.out = new PrintWriter(output);
            this.input = input;
            this.output = output;
        } catch(FileNotFoundException e) {
            e.printStackTrace();
        }

        this.source();
    }

    public void writeToFile(String string) {
        out.write(string + "\n");
    }

    public void close() {
        out.close();
    }

    public void push(String suffix, int parameter) {
        switch(suffix) {
            case "b" -> writeToFile(String.format("\tpushb\t%d", parameter));
            case "a" -> writeToFile(String.format("\tpusha\t%d", parameter));
            case "bp" -> writeToFile("\tpush\t bp");
            default -> writeToFile(String.format("\tpushi\t%d", parameter));
        }

    }

    public void pushf(double realConstant) {
        writeToFile("\tpushf\t"+ realConstant);
    }

    public void load(String suffix) {
        switch(suffix) {
            case "b" -> writeToFile("\tloadb");
            case "f" -> writeToFile("\tloadf");
            default -> writeToFile("\tloadi");
        }
    }

    public void store(String suffix) {
        switch (suffix) {
            case "b" -> writeToFile("\tstoreb");
            case "f" -> writeToFile("\tstoref");
            default -> writeToFile("\tstorei");
        }
    }

    public void pop(String suffix) {
        switch (suffix) {
            case "b" -> writeToFile("\tpopb");
            case "f" -> writeToFile("\tpopf");
            default -> writeToFile("\tpopi");
        }
    }

    public void dup(String suffix) {
        switch (suffix) {
            case "b" -> writeToFile("\tdupb");
            case "f" -> writeToFile("\tdupf");
            default -> writeToFile("\tdupi");
        }
    }

    // Arithmetic operations
    public void add(String suffix) {
        if(suffix.equals("f"))
            writeToFile("\taddf");
        else
            writeToFile("\taddi");
    }

    public void sub(String suffix) {
        if(suffix.equals("f"))
            writeToFile("\tsubf");
        else
            writeToFile("\tsubi");
    }

    public void mul(String suffix) {
        if(suffix.equals("f"))
            writeToFile("\tmulf");
        else
            writeToFile("\tmuli");
    }

    public void div(String suffix) {
        if(suffix.equals("f"))
            writeToFile("\tdivf");
        else
            writeToFile("\tdivi");
    }

    public void mod(String suffix) {
        if(suffix.equals("f"))
            writeToFile("\tdivf");
        else
            writeToFile("\tdivi");
    }

    // Comparison operations
    public void gt(String suffix) {
        if(suffix.equals("f"))
            writeToFile("\tgtf");
        else
            writeToFile("\tgti");
    }

    public void lt(String suffix) {
        if(suffix.equals("f"))
            writeToFile("\tltf");
        else
            writeToFile("\tlti");
    }

    public void ge(String suffix) {
        if(suffix.equals("f"))
            writeToFile("\tgef");
        else
            writeToFile("\tgei");
    }

    public void le(String suffix) {
        if(suffix.equals("f"))
            writeToFile("\tlef");
        else
            writeToFile("\tlei");
    }

    public void eq(String suffix) {
        if(suffix.equals("f"))
            writeToFile("\teqf");
        else
            writeToFile("\teqi");
    }

    public void ne(String suffix) {
        if(suffix.equals("f"))
            writeToFile("\tnef");
        else
            writeToFile("\tnei");
    }

    // Logical operations
    public void and() {
        writeToFile("\tand");
    }

    public void or() {
        writeToFile("\tor");
    }

    public void not() {
        writeToFile("\tnot");
    }

    public void out(String suffix) {
        switch (suffix) {
            case "b" -> writeToFile("\toutb");
            case "f" -> writeToFile("\toutf");
            default -> writeToFile("\touti");
        }
    }
    public void in(String suffix) {
        switch (suffix) {
            case "b" -> writeToFile("\tinb");
            case "f" -> writeToFile("\tinf");
            default -> writeToFile("\tini");
        }
    }

    // Label definition
    public void label(String id) {
        writeToFile(id + ":");
    }

    public String nextLabel() {
        String label = String.format("label%d", labelCounter);
        labelCounter++;
        return label;

    }

    // Jump instructions
    public void jmp(String id) {
        writeToFile(String.format("\tjmp\t%s", id));
    }

    public void jz(String id) {
        writeToFile(String.format("\tjz\t%s", id));
    }

    public void jnz(String id) {
        writeToFile(String.format("\tjnz\t%s", id));
    }

    // Function instructions
    public void call(String id) {
        writeToFile(String.format("\tcall %s", id));
    }

    public void enter(int bytes) {
        writeToFile(String.format("\tenter\t%d", bytes));
    }

    public void ret(int returnBytes, int localBytes, int argBytes) {
        writeToFile(String.format("\tret\t%d, %d, %d", returnBytes, localBytes, argBytes));
    }

    public void halt() {
        writeToFile("halt");
    }

    // Debugging info
    public void source() {
        writeToFile(String.format("#source\t%s", input));
    }

    public void line(int line) {
        writeToFile(String.format("#line\t%d", line));
    }

    public void newLine() {writeToFile("");}
}
