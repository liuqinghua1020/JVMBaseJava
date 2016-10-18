package com.shark.JVMBasejava.classfile.constant;

import com.shark.JVMBasejava.classfile.ClassReader;
import com.shark.JVMBasejava.classfile.ConstantPool;

/**
 * Created by liuqinghua on 16-10-16.
 */
public class ConstantDoubleInfo extends ConstantInfo {

    private double val;

    public ConstantDoubleInfo(ClassReader classReader, ConstantPool constantPool) {
        super(classReader, constantPool);
    }

    @Override
    public void readInfo() throws Exception {
        long intVal = this.getClassReader().readUnit64();
        this.val = Double.longBitsToDouble(intVal);
    }

    public double getVal() {
        return val;
    }

    public void setVal(double val) {
        this.val = val;
    }
}
