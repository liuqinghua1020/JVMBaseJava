package com.shark.JVMBasejava.classfile.constant;

import com.shark.JVMBasejava.classfile.ClassReader;
import com.shark.JVMBasejava.classfile.ConstantPool;
import com.shark.JVMBasejava.exception.ConstantPoolException;

/**
 * Created by liuqinghua on 16-10-18.
 */
public class ConstantMemberrefInfo extends ConstantInfo {

    private int classIndex;
    private int nameAndTypeIndex;

    public ConstantMemberrefInfo(ClassReader classReader, ConstantPool constantPool) {
        super(classReader, constantPool);
    }

    @Override
    public void readInfo() throws Exception {
        this.classIndex = this.getClassReader().readUnit16();
        this.nameAndTypeIndex = this.getClassReader().readUnit16();
    }

    public int getClassIndex() {
        return classIndex;
    }


    public String className(){
        try {
            return this.getConstantPool().getClassName(this.classIndex);
        } catch (ConstantPoolException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String[] nameAndDescriptor(){
        try {
            return this.getConstantPool().getNameAndType(this.nameAndTypeIndex);
        } catch (ConstantPoolException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void setClassIndex(int classIndex) {
        this.classIndex = classIndex;
    }

    public int getNameAndTypeIndex() {
        return nameAndTypeIndex;
    }

    public void setNameAndTypeIndex(int nameAndTypeIndex) {
        this.nameAndTypeIndex = nameAndTypeIndex;
    }
}
