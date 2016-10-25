package com.shark.JVMBasejava.classfile.attribute;

import com.shark.JVMBasejava.classfile.ClassReader;

import java.io.IOException;

/**
 * Created by liuqinghua on 16-10-25.
 */
public class LineNumberTableEntry {

    private int startPc;
    private int lineNumber;

    public static LineNumberTableEntry[] readLineNumberTableEntrys(ClassReader classReader) throws IOException {
        int lineNumberTableEntryLength = classReader.readUnit16();
        LineNumberTableEntry[] lineNumberTableEntries = new LineNumberTableEntry[lineNumberTableEntryLength];
        for(int i=0;i<lineNumberTableEntryLength;i++){
            lineNumberTableEntries[i] = LineNumberTableEntry.readLineNumberTableEntry(classReader);
        }

        return lineNumberTableEntries;
    }


    public static LineNumberTableEntry readLineNumberTableEntry(ClassReader classReader) throws IOException {
        LineNumberTableEntry lineNumberTableEntry = new LineNumberTableEntry();
        lineNumberTableEntry.setStartPc(classReader.readUnit16());
        lineNumberTableEntry.setLineNumber(classReader.readUnit16());
        return  lineNumberTableEntry;
    }

    public int getStartPc() {
        return startPc;
    }

    public void setStartPc(int startPc) {
        this.startPc = startPc;
    }

    public int getLineNumber() {
        return lineNumber;
    }

    public void setLineNumber(int lineNumber) {
        this.lineNumber = lineNumber;
    }
}
