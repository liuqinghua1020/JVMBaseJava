package com.shark.JVMBasejava.classfile.attribute;

import com.shark.JVMBasejava.classfile.ClassReader;
import com.shark.JVMBasejava.classfile.ConstantPool;

/**
 * Created by liuqinghua on 16-10-20.
 */
public class ConstantValueAttribute extends AttributeInfo {

    private int constantValueIndex;

    public ConstantValueAttribute(String attrName, int attrLen, ClassReader classReader, ConstantPool constantPool) {
        super(classReader, constantPool, attrName, attrLen);
    }

    @Override
    public void readInfo() throws Exception {
        this.constantValueIndex = this.getClassReader().readUnit16();
    }

    public int getConstantValueIndex() {
        return constantValueIndex;
    }

    public void setConstantValueIndex(int constantValueIndex) {
        this.constantValueIndex = constantValueIndex;
    }
}
