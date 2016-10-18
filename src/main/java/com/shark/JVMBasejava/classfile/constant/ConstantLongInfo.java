package com.shark.JVMBasejava.classfile.constant;

import com.shark.JVMBasejava.classfile.ClassReader;
import com.shark.JVMBasejava.classfile.ConstantPool;
import com.shark.JVMBasejava.classfile.constant.ConstantInfo;

/**
 * Created by liuqinghua on 16-10-16.
 */
public class ConstantLongInfo extends ConstantInfo {

    private long val;

    public ConstantLongInfo(ClassReader classReader, ConstantPool constantPool) {
        super(classReader, constantPool);
    }

    @Override
    public void readInfo() throws Exception {
        this.val = this.getClassReader().readUnit64();
    }

    public long getVal() {
        return val;
    }

    public void setVal(long val) {
        this.val = val;
    }
}
