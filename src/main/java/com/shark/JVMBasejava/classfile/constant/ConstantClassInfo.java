package com.shark.JVMBasejava.classfile.constant;

import com.shark.JVMBasejava.classfile.ClassReader;
import com.shark.JVMBasejava.classfile.ConstantPool;

/**
 * Created by liuqinghua on 16-10-16.
 */
public class ConstantClassInfo extends ConstantInfo {

    private int nameIndex;

    public ConstantClassInfo(ClassReader classReader, ConstantPool constantPool) {
        super(classReader, constantPool);
    }

    public int getNameIndex() {
        return nameIndex;
    }

    public void setNameIndex(int nameIndex) {
        this.nameIndex = nameIndex;
    }
}
