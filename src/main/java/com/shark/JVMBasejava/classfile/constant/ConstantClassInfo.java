package com.shark.JVMBasejava.classfile.constant;

import com.shark.JVMBasejava.classfile.ClassReader;
import com.shark.JVMBasejava.classfile.ConstantPool;
import com.shark.JVMBasejava.exception.ConstantPoolException;

/**
 * Created by liuqinghua on 16-10-16.
 */
public class ConstantClassInfo extends ConstantInfo {

    private int nameIndex;

    public ConstantClassInfo(ClassReader classReader, ConstantPool constantPool) {
        super(classReader, constantPool);
    }

    @Override
    public void readInfo() throws Exception {
        this.nameIndex = this.getClassReader().readUnit16();
    }

    public int getNameIndex() {
        return nameIndex;
    }

    public void setNameIndex(int nameIndex) {
        this.nameIndex = nameIndex;
    }

    public String name(){
        try {
            return this.getConstantPool().getUTF8(this.nameIndex);
        } catch (ConstantPoolException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String toString(){
        try {
            return this.getConstantPool().getUTF8(this.nameIndex);
        } catch (ConstantPoolException e) {
            e.printStackTrace();
        }
        return null;
    }
}
