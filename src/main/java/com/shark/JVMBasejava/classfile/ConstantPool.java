package com.shark.JVMBasejava.classfile;

import com.shark.JVMBasejava.classfile.constant.ConstantClassInfo;
import com.shark.JVMBasejava.classfile.constant.ConstantInfo;
import com.shark.JVMBasejava.classfile.constant.ConstantNameAndTypeInfo;
import com.shark.JVMBasejava.classfile.constant.ConstantUTF8Info;
import com.shark.JVMBasejava.exception.ConstantPoolException;

import java.io.IOException;

/**
 * Created by liuqinghua on 16-10-15.
 */
public class ConstantPool {

    private ConstantInfo[] constantInfos;
    private ClassReader classReader;

    public ConstantPool(ClassReader classReader, ConstantInfo[] constantInfos){
        this.classReader = classReader;
        this.constantInfos = constantInfos;
    }

    public static ConstantPool readConstantPool(ClassReader classReader) throws IOException {
        int cpCount = classReader.readUnit16();
        ConstantInfo[] constantInfos = new ConstantInfo[cpCount];
        ConstantPool constantPool = new ConstantPool(classReader, constantInfos);
        for(int i=0;i<cpCount;i++){
            constantInfos[i] = ConstantInfo.readConstantInfo(classReader, constantPool);
            switch (constantInfos[i].getType()){
                case ConstantInfo.CONASTANT_Long_info:
                case ConstantInfo.CONSTANT_Double_info:
                    i++;
            }
        }

        return constantPool;
    }

    public ConstantInfo getContantInfo(int index) throws ConstantPoolException {
        if(index >= 0 && constantInfos != null && constantInfos.length > index){
            ConstantInfo constantInfo = this.constantInfos[index];
            if(constantInfo == null){
                throw new ConstantPoolException("Invalid constant pool element");
            }
        }

        throw new ConstantPoolException("Invalid constant pool index");
    }

    public String[] getNameAndType(int index) throws ConstantPoolException {
        ConstantNameAndTypeInfo constantNameAndTypeInfo = (ConstantNameAndTypeInfo)this.getContantInfo(index);
        String[] result = new String[2];
        result[0] = this.getUTF8(constantNameAndTypeInfo.getNameIndex());
        result[1] = this.getUTF8(constantNameAndTypeInfo.getDescriptorIndex());
        return result;
    }

    public String getClassName(int index) throws ConstantPoolException {
        ConstantClassInfo constantClassInfo = (ConstantClassInfo)this.getContantInfo(index);
        return this.getUTF8(constantClassInfo.getNameIndex());
    }

    public String getUTF8(int index) throws ConstantPoolException {
        ConstantUTF8Info constantUTF8Info = (ConstantUTF8Info)this.getContantInfo(index);
        return constantUTF8Info.getString();
    }

    public ClassReader getClassReader() {
        return classReader;
    }

    public void setClassReader(ClassReader classReader) {
        this.classReader = classReader;
    }

    public ConstantInfo[] getConstantInfos() {
        return constantInfos;
    }

    public void setConstantInfos(ConstantInfo[] constantInfos) {
        this.constantInfos = constantInfos;
    }
}
