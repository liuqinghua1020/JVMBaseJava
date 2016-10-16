package com.shark.JVMBasejava.classfile.constant;

import com.shark.JVMBasejava.classfile.ClassReader;
import com.shark.JVMBasejava.classfile.ConstantPool;
import com.shark.JVMBasejava.classfile.constant.ConstantInfo;

/**
 * Created by liuqinghua on 16-10-16.
 */
public class ConstantMethodHandleInfo extends ConstantInfo {
    public ConstantMethodHandleInfo(ClassReader classReader, ConstantPool constantPool) {
        super(classReader, constantPool);
    }
}
