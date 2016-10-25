package com.shark.JVMBasejava.classfile.attribute;

import com.shark.JVMBasejava.classfile.ClassReader;
import com.shark.JVMBasejava.classfile.ConstantPool;
import sun.java2d.pipe.AATextRenderer;

/**
 * Created by liuqinghua on 16-10-20.
 */
public class CodeAttribute extends AttributeInfo {

    private int maxStack;
    private int maxLocals;
    private byte[] code;
    private ExceptionTableEntry[] exceptionTableEntries;
    private AttributeInfo[] attributeInfos;

    public CodeAttribute(String attrName, int attrLen, ClassReader classReader, ConstantPool constantPool) {
        super(classReader, constantPool, attrName, attrLen);

    }

    @Override
    public void readInfo() throws Exception {
        this.maxStack = this.getClassReader().readUnit16();
        this.maxLocals = this.getClassReader().readUnit16();
        int codeLength = this.getClassReader().readUnit32();
        this.code = this.getClassReader().readBytes(codeLength);
        this.exceptionTableEntries = ExceptionTableEntry.readExceptionTables(this.getClassReader());
        this.attributeInfos = AttributeInfo.readAttributes(this.getClassReader(), this.getConstantPool());
    }

    public int getMaxStack() {
        return maxStack;
    }

    public void setMaxStack(int maxStack) {
        this.maxStack = maxStack;
    }

    public int getMaxLocals() {
        return maxLocals;
    }

    public void setMaxLocals(int maxLocals) {
        this.maxLocals = maxLocals;
    }

    public byte[] getCode() {
        return code;
    }

    public void setCode(byte[] code) {
        this.code = code;
    }

    public ExceptionTableEntry[] getExceptionTableEntries() {
        return exceptionTableEntries;
    }

    public void setExceptionTableEntries(ExceptionTableEntry[] exceptionTableEntries) {
        this.exceptionTableEntries = exceptionTableEntries;
    }

    public AttributeInfo[] getAttributeInfos() {
        return attributeInfos;
    }

    public void setAttributeInfos(AttributeInfo[] attributeInfos) {
        this.attributeInfos = attributeInfos;
    }
}
