package com.shark.JVMBasejava.classfile.attribute;

import com.shark.JVMBasejava.classfile.ClassReader;
import com.shark.JVMBasejava.classfile.ConstantPool;

/**
 * Created by liuqinghua on 16-10-20.
 */
public class DeprecatedAttribute extends AttributeInfo {
    public DeprecatedAttribute(String attrName, int attrLen, ClassReader classReader, ConstantPool constantPool) {
        super(classReader, constantPool, attrName, attrLen);
    }

    @Override
    public void readInfo() throws Exception {

    }
}
