package com.shark.JVMBasejava.classfile.constant;

import com.shark.JVMBasejava.classfile.ClassReader;
import com.shark.JVMBasejava.classfile.ConstantPool;
import com.shark.JVMBasejava.classfile.constant.ConstantInfo;

/**
 * Created by liuqinghua on 16-10-16.
 */
public class ConstantUTF8Info extends ConstantInfo {

    private String string;

    public ConstantUTF8Info(ClassReader classReader, ConstantPool constantPool) {
        super(classReader, constantPool);
    }

    @Override
    public void readInfo() throws Exception {
        this.string = this.getClassReader().readUTF8();
    }

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }
}
