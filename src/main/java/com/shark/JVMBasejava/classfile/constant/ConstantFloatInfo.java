package com.shark.JVMBasejava.classfile.constant;

import com.shark.JVMBasejava.classfile.ClassReader;
import com.shark.JVMBasejava.classfile.ConstantPool;

/**
 * Created by liuqinghua on 16-10-16.
 */
public class ConstantFloatInfo extends ConstantInfo {

    private float val;

    public ConstantFloatInfo(ClassReader classReader, ConstantPool constantPool) {
        super(classReader, constantPool);
    }

    @Override
    public void readInfo() throws Exception {
        int intVal = this.getClassReader().readUnit32();
        this.val = Float.intBitsToFloat(intVal);
    }

    public float getVal() {
        return val;
    }

    public void setVal(float val) {
        this.val = val;
    }
}
