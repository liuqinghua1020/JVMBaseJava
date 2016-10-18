package com.shark.JVMBasejava.classfile.constant;

import com.shark.JVMBasejava.classfile.ClassReader;
import com.shark.JVMBasejava.classfile.ConstantPool;
import com.shark.JVMBasejava.classfile.constant.ConstantInfo;
import com.shark.JVMBasejava.exception.ConstantPoolException;

/**
 * Created by liuqinghua on 16-10-16.
 */
public class ConstantStringInfo extends ConstantInfo {

    private int stringIndex;

    public ConstantStringInfo(ClassReader classReader, ConstantPool constantPool) {
        super(classReader, constantPool);
    }

    @Override
    public void readInfo() throws Exception {
        this.stringIndex = this.getClassReader().readUnit16();
    }

    public int getStringIndex() {
        return stringIndex;
    }

    public void setStringIndex(int stringIndex) {
        this.stringIndex = stringIndex;
    }

    @Override
    public String toString(){
        try {
            return this.getConstantPool().getUTF8(this.stringIndex);
        } catch (ConstantPoolException e) {
            e.printStackTrace();
        }
        return null;
    }
}
