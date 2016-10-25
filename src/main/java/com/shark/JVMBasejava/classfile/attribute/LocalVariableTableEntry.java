package com.shark.JVMBasejava.classfile.attribute;

import com.shark.JVMBasejava.classfile.ClassReader;

import java.io.IOException;

/**
 * Created by liuqinghua on 16-10-25.
 */
public class LocalVariableTableEntry {

    private int startPc;
    private int length;
    private int nameIndex;
    private int descriptorIndex;
    private int index;

    public static LocalVariableTableEntry[] readLocalVariableTableEntrys(ClassReader classReader) throws IOException {
        int localVariableTableEntryLength = classReader.readUnit16();
        LocalVariableTableEntry[] localVariableTableEntries = new LocalVariableTableEntry[localVariableTableEntryLength];
        for(int i=0;i<localVariableTableEntryLength;i++){
            localVariableTableEntries[i] = readLocalVariableTableEntry(classReader);
        }
        return localVariableTableEntries;
    }

    private static LocalVariableTableEntry readLocalVariableTableEntry(ClassReader classReader) throws IOException {
        LocalVariableTableEntry localVariableTableEntry = new LocalVariableTableEntry();
        localVariableTableEntry.setStartPc(classReader.readUnit16());
        localVariableTableEntry.setLength(classReader.readUnit16());
        localVariableTableEntry.setNameIndex(classReader.readUnit16());
        localVariableTableEntry.setDescriptorIndex(classReader.readUnit16());
        localVariableTableEntry.setIndex(classReader.readUnit16());
        return localVariableTableEntry;
    }

    public int getStartPc() {
        return startPc;
    }

    public void setStartPc(int startPc) {
        this.startPc = startPc;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getNameIndex() {
        return nameIndex;
    }

    public void setNameIndex(int nameIndex) {
        this.nameIndex = nameIndex;
    }

    public int getDescriptorIndex() {
        return descriptorIndex;
    }

    public void setDescriptorIndex(int descriptorIndex) {
        this.descriptorIndex = descriptorIndex;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
