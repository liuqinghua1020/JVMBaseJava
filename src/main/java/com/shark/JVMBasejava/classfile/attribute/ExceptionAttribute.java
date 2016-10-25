package com.shark.JVMBasejava.classfile.attribute;

import com.shark.JVMBasejava.classfile.ClassReader;
import com.shark.JVMBasejava.classfile.ConstantPool;

/**
 * Created by liuqinghua on 16-10-20.
 */
public class ExceptionAttribute extends AttributeInfo {

     private int[] exceptionIndexTable;

    public ExceptionAttribute(String attrName, int attrLen, ClassReader classReader, ConstantPool constantPool) {
        super(classReader, constantPool, attrName, attrLen);
    }

    @Override
    public void readInfo() throws Exception {
        this.exceptionIndexTable = this.getClassReader().readUnit16s();
    }

    public int[] getExceptionIndexTable() {
        return exceptionIndexTable;
    }

    public void setExceptionIndexTable(int[] exceptionIndexTable) {
        this.exceptionIndexTable = exceptionIndexTable;
    }
}
