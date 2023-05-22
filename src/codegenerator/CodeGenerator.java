package codegenerator;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CodeGenerator {

    private BufferedWriter bufferedWriter;
    private int labelCounter;

    public CodeGenerator(String input, String output) {

        labelCounter = 0;

        try {
            this.bufferedWriter = new BufferedWriter(new FileWriter(output));
        } catch(IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private void writeToFile(String string) {
        try {
            bufferedWriter.write(string);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private void close() {
        try {
            bufferedWriter.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    // Comments
    public void comment(String comment) {
        writeToFile(String.format("\t' * %s", comment));
    }

    // Push instructions
    public void pushb(int asciiCode) {
        writeToFile(String.format("\tpushb\t%d", asciiCode));
    }

    public void push(int intConstant) {
        writeToFile(String.format("\tpush\t%d", intConstant));
    }

    public void pushf(double realConstant) {
        writeToFile(String.format("\tpushf\t%f", realConstant));
    }

    public void pusha(int address) {
        writeToFile(String.format("\tpusha\t%d", address));
    }

    public void pushbp() {
        writeToFile("\tpush\t bp");
    }

    // Load instruction
    public void loadb() {
        writeToFile("\tloadb");
    }

    public void load() {
        writeToFile("\tload");
    }

    public void loadf() {
        writeToFile("\tloadf");
    }

    // Store instruction
    public void storeb() {
        writeToFile("\tstoreb");
    }

    public void store() {
        writeToFile("\tstore");
    }

    public void storef() {
        writeToFile("\tstoref");
    }

    // Pop instructions
    public void popb() {
        writeToFile("\tpopb");
    }

    public void pop() {
        writeToFile("\tpop");
    }

    public void popf() {
        writeToFile("\tpopf");
    }

    // Dup instructions
    public void dupb() {
        writeToFile("\tdupb");
    }

    public void dup() {
        writeToFile("\tdup");
    }

    public void dupf() {
        writeToFile("\tdupf");
    }

    // Arithmetic operations
    public void add() {
        writeToFile("\tadd");
    }

    public void addf() {
        writeToFile("\taddf");
    }
    public void sub() {
        writeToFile("\tsub");
    }

    public void subf() {
        writeToFile("\tsubf");
    }

    public void mul() {
        writeToFile("\tmul");
    }

    public void mulf() {
        writeToFile("\tmulf");
    }

    public void div() {
        writeToFile("\tdiv");
    }

    public void divf() {
        writeToFile("\tdivf");
    }

    public void mod() {
        writeToFile("\tmod");
    }

    public void modf() {
        writeToFile("\tmodf");
    }

    // Comparison operations
    public void gt() {
        writeToFile("\tgt");
    }

    public void gtf() {
        writeToFile("\tgtf");
    }

    public void lt() {
        writeToFile("\tlt");
    }

    public void ltf() {
        writeToFile("\tltf");
    }

    public void ge() {
        writeToFile("\tge");
    }

    public void gef() {
        writeToFile("\tgef");
    }

    public void le() {
        writeToFile("\tle");
    }

    public void lef() {
        writeToFile("\tlef");
    }

    public void eq() {
        writeToFile("\teq");
    }

    public void eqf() {
        writeToFile("\teqf");
    }

    public void ne() {
        writeToFile("\tne");
    }

    public void nef() {
        writeToFile("\tnef");
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

    // Input output
    public void outb() {
        writeToFile("\toutb");
    }
    public void out() {
        writeToFile("\tout");
    }
    public void outf() {
        writeToFile("\toutf");
    }

    public void inb() {
        writeToFile("\tinb");
    }
    public void in() {
        writeToFile("\tin");
    }
    public void inf() {
        writeToFile("\tinf");
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
        writeToFile(id);
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
        writeToFile(String.format("\tcall\t%s", id));
    }

    public void enter(int bytes) {
        writeToFile(String.format("\tenter\t%d", bytes));
    }

    public void ret(int returnBytes, int localBytes, int argBytes) {
        writeToFile(String.format("\tret\t%d, %d, %d", returnBytes, localBytes, argBytes));
    }

    public void halt() {
        writeToFile("\thalt");
    }

    // Debugging info
    public void source(String fileName) {
        writeToFile(String.format("#source\t%s", fileName));
    }

    public void line(int line) {
        writeToFile(String.format("#line\t%d", line));
    }


}
