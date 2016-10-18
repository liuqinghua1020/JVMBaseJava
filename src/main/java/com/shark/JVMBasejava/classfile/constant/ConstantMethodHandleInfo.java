package com.shark.JVMBasejava.classfile.constant;

import com.shark.JVMBasejava.classfile.ClassReader;
import com.shark.JVMBasejava.classfile.ConstantPool;
import com.shark.JVMBasejava.classfile.constant.ConstantInfo;

/**
 * Created by liuqinghua on 16-10-16.
 */
public class ConstantMethodHandleInfo extends ConstantInfo {

    private int referenceKind;
    private int referenceIndex;

    public ConstantMethodHandleInfo(ClassReader classReader, ConstantPool constantPool) {
        super(classReader, constantPool);
    }

    @Override
    public void readInfo() throws Exception {
        this.referenceKind = this.getClassReader().readUnit16();
        this.referenceIndex = this.getClassReader().readUnit16();
    }

    public int getReferenceKind() {
        return referenceKind;
    }

    public void setReferenceKind(int referenceKind) {
        this.referenceKind = referenceKind;
    }

    public int getReferenceIndex() {
        return referenceIndex;
    }

    public void setReferenceIndex(int referenceIndex) {
        this.referenceIndex = referenceIndex;
    }
}
