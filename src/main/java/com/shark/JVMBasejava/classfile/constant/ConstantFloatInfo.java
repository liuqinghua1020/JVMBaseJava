package com.shark.JVMBasejava.classfile.constant;

import com.shark.JVMBasejava.classfile.ClassReader;
import com.shark.JVMBasejava.classfile.ConstantPool;

/**
 * Created by liuqinghua on 16-10-16.
 */
public class ConstantFloatInfo extends ConstantInfo {
    public ConstantFloatInfo(ClassReader classReader, ConstantPool constantPool) {
        super(classReader, constantPool);
    }
}