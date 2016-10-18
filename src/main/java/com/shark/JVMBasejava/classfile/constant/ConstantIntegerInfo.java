package com.shark.JVMBasejava.classfile.constant;

import com.shark.JVMBasejava.classfile.ClassReader;
import com.shark.JVMBasejava.classfile.ConstantPool;
import com.shark.JVMBasejava.classfile.constant.ConstantInfo;

/**
 * Created by liuqinghua on 16-10-16.
 */
public class ConstantIntegerInfo extends ConstantInfo {

    private int val;

    public ConstantIntegerInfo(ClassReader classReader, ConstantPool constantPool) {
        super(classReader, constantPool);
    }

    @Override
    public void readInfo() throws Exception {
        this.val = this.getClassReader().readUnit32();
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }
}
