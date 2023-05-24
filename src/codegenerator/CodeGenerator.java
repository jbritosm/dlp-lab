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

    private void writeToFile(String string) {
        out.write(string + "\n");
    }

    public void close() {
        out.close();
    }

    // Comments
    public void comment(String comment) {
        writeToFile(String.format("\t' * %s", comment));
    }

    public void push(String suffix, int parameter) {
        switch(suffix) {
            case "b" -> writeToFile(String.format("\tpushb\t%d", parameter));
            case "a" -> writeToFile(String.format("\tpusha\t%d", parameter));
            case "bp" -> writeToFile("\tpush\t bp");
            default -> writeToFile(String.format("\tpush\t%d", parameter));
        }

    }

    public void pushf(double realConstant) {
        writeToFile(String.format("\tpushf\t%f", realConstant));
    }

    public void load(String suffix) {
        switch(suffix) {
            case "b" -> writeToFile("\tloadb");
            case "f" -> writeToFile("\tloadf");
            default -> writeToFile("\tload");
        }
    }

    public void store(String suffix) {
        switch (suffix) {
            case "b" -> writeToFile("\tstoreb");
            case "f" -> writeToFile("\tstoref");
            default -> writeToFile("\tstore");
        }
    }

    public void pop(String suffix) {
        switch (suffix) {
            case "b" -> writeToFile("\tpopb");
            case "f" -> writeToFile("\tpopf");
            default -> writeToFile("\tpop");
        }
    }

    public void dup(String suffix) {
        switch (suffix) {
            case "b" -> writeToFile("\tdupb");
            case "f" -> writeToFile("\tdupf");
            default -> writeToFile("\tdup");
        }
    }

    // Arithmetic operations
    public void add(String suffix) {
        if(suffix.equals("f"))
            writeToFile("\taddf");
        else
            writeToFile("\tadd");
    }

    public void sub(String suffix) {
        if(suffix.equals("f"))
            writeToFile("\tsubf");
        else
            writeToFile("\tsub");
    }

    public void mul(String suffix) {
        if(suffix.equals("f"))
            writeToFile("\tmulf");
        else
            writeToFile("\tmul");
    }

    public void div(String suffix) {
        if(suffix.equals("f"))
            writeToFile("\tdivf");
        else
            writeToFile("\tdiv");
    }

    public void mod(String suffix) {
        if(suffix.equals("f"))
            writeToFile("\tdivf");
        else
            writeToFile("\tdiv");
    }

    // Comparison operations
    public void gt(String suffix) {
        if(suffix.equals("f"))
            writeToFile("\tgtf");
        else
            writeToFile("\tgt");
    }

    public void lt(String suffix) {
        if(suffix.equals("f"))
            writeToFile("\tltf");
        else
            writeToFile("\tlt");
    }

    public void ge(String suffix) {
        if(suffix.equals("f"))
            writeToFile("\tgef");
        else
            writeToFile("\tge");
    }

    public void le(String suffix) {
        if(suffix.equals("f"))
            writeToFile("\tlef");
        else
            writeToFile("\tle");
    }

    public void eq(String suffix) {
        if(suffix.equals("f"))
            writeToFile("\teqf");
        else
            writeToFile("\teq");
    }

    public void ne(String suffix) {
        if(suffix.equals("f"))
            writeToFile("\tnef");
        else
            writeToFile("\tne");
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
            default -> writeToFile("\tout");
        }
    }
    public void in(String suffix) {
        switch (suffix) {
            case "b" -> writeToFile("\tinb");
            case "f" -> writeToFile("\tinf");
            default -> writeToFile("\tin");
        }
    }

    // Conversion instructions
    public void b2i() {
        writeToFile("\tb2i");
    }

    public void i2f() {
        writeToFile("\ti2f");
    }

    public void f2i() {
        writeToFile("\tf2i");
    }

    public void i2b() {
        writeToFile("\ti2b");
    }

    // Label definition
    public void label(String id) {
        writeToFile(id + ":");
    }

    public String nextLabel() {
        String label = String.format("label%d:", labelCounter);
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
        writeToFile(String.format("call %s", id));
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
