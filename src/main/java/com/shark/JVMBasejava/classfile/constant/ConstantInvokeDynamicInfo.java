package com.shark.JVMBasejava.classfile.constant;

import com.shark.JVMBasejava.classfile.ClassReader;
import com.shark.JVMBasejava.classfile.ConstantPool;
import com.shark.JVMBasejava.classfile.constant.ConstantInfo;

/**
 * Created by liuqinghua on 16-10-16.
 */
public class ConstantInvokeDynamicInfo extends ConstantInfo {

    private int bootstrapMethodAttrIndex;
    private int nameAndTypeIndex;

    public ConstantInvokeDynamicInfo(ClassReader classReader, ConstantPool constantPool) {
        super(classReader, constantPool);
    }

    @Override
    public void readInfo() throws Exception {
        this.bootstrapMethodAttrIndex = this.getClassReader().readUnit16();
        this.nameAndTypeIndex = this.getClassReader().readUnit16();
    }

    public int getBootstrapMethodAttrIndex() {
        return bootstrapMethodAttrIndex;
    }

    public void setBootstrapMethodAttrIndex(int bootstrapMethodAttrIndex) {
        this.bootstrapMethodAttrIndex = bootstrapMethodAttrIndex;
    }

    public int getNameAndTypeIndex() {
        return nameAndTypeIndex;
    }

    public void setNameAndTypeIndex(int nameAndTypeIndex) {
        this.nameAndTypeIndex = nameAndTypeIndex;
    }
}
