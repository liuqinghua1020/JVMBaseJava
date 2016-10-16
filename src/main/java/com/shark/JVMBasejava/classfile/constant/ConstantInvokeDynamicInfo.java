package com.shark.JVMBasejava.classfile.constant;

import com.shark.JVMBasejava.classfile.ClassReader;
import com.shark.JVMBasejava.classfile.ConstantPool;
import com.shark.JVMBasejava.classfile.constant.ConstantInfo;

/**
 * Created by liuqinghua on 16-10-16.
 */
public class ConstantInvokeDynamicInfo extends ConstantInfo {
    public ConstantInvokeDynamicInfo(ClassReader classReader, ConstantPool constantPool) {
        super(classReader, constantPool);
    }
}
