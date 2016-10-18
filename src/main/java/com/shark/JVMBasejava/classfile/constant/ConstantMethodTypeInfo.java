package com.shark.JVMBasejava.classfile.constant;

import com.shark.JVMBasejava.classfile.ClassReader;
import com.shark.JVMBasejava.classfile.ConstantPool;
import com.shark.JVMBasejava.classfile.constant.ConstantInfo;

/**
 * Created by liuqinghua on 16-10-16.
 */
public class ConstantMethodTypeInfo extends ConstantInfo {

    private int descriptorIndex;

    public ConstantMethodTypeInfo(ClassReader classReader, ConstantPool constantPool) {
        super(classReader, constantPool);
    }

    @Override
    public void readInfo() throws Exception {
        this.descriptorIndex = this.getClassReader().readUnit16();
    }

    public int getDescriptorIndex() {
        return descriptorIndex;
    }

    public void setDescriptorIndex(int descriptorIndex) {
        this.descriptorIndex = descriptorIndex;
    }
}
