package com.shark.JVMBasejava.classfile.attribute;

import com.shark.JVMBasejava.classfile.ClassReader;

import java.io.IOException;

/**
 * Created by liuqinghua on 16-10-25.
 */
public class ExceptionTableEntry {
    private int startPc;
    private int endPc;
    private int handlerPc;
    private int catchType;


    public static ExceptionTableEntry[] readExceptionTables(ClassReader classReader) throws IOException {
        int exceptionTableLength = classReader.readUnit16();
        ExceptionTableEntry[] exceptionTableEntries = new ExceptionTableEntry[exceptionTableLength];
        for(int i=0;i<exceptionTableLength;i++){
            exceptionTableEntries[i] = readExceptionTable(classReader);
        }
        return exceptionTableEntries;
    }
    public static ExceptionTableEntry readExceptionTable(ClassReader classReader) throws IOException {
        ExceptionTableEntry ee = new ExceptionTableEntry();
        ee.setStartPc(classReader.readUnit16());
        ee.setEndPc(classReader.readUnit16());
        ee.setHandlerPc(classReader.readUnit16());
        ee.setCatchType(classReader.readUnit16());
        return ee;
    }

    public int getStartPc() {
        return startPc;
    }

    public void setStartPc(int startPc) {
        this.startPc = startPc;
    }

    public int getEndPc() {
        return endPc;
    }

    public void setEndPc(int endPc) {
        this.endPc = endPc;
    }

    public int getHandlerPc() {
        return handlerPc;
    }

    public void setHandlerPc(int handlerPc) {
        this.handlerPc = handlerPc;
    }

    public int getCatchType() {
        return catchType;
    }

    public void setCatchType(int catchType) {
        this.catchType = catchType;
    }
}
