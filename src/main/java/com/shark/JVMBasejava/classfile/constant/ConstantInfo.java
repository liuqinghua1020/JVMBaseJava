package com.shark.JVMBasejava.classfile.constant;

import com.shark.JVMBasejava.classfile.*;

import java.io.IOException;

/**
 * Created by liuqinghua on 16-10-15.
 */
public abstract class ConstantInfo {

    public static final int CONASTANT_Class_info = 7;
    public static final int CONASTANT_Fieldref_info = 9;
    public static final int CONSTANT_Methodref_info = 10;
    public static final int CONASTANT_InterfaceMethodref_info = 11;
    public static final int CONASTANT_String_info = 8;
    public static final int CONSTANT_Integer_info = 3;
    public static final int CONASTANT_Float_info = 4;
    public static final int CONASTANT_Long_info = 5;
    public static final int CONSTANT_Double_info = 6;
    public static final int CONASTANT_NameAndType_info = 12;
    public static final int CONASTANT_UTF8_info = 1;
    public static final int CONSTANT_MethodHandle_info = 15;
    public static final int CONASTANT_MethodType_info = 16;
    public static final int CONSTANT_InvokeDynamic_info = 18;

    private ClassReader classReader;
    private ConstantPool constantPool;

    private int type;

    public ConstantInfo(ClassReader classReader,ConstantPool constantPool){
        this.classReader = classReader;
        this.constantPool = constantPool;
    }

    public static ConstantInfo readConstantInfo(ClassReader classReader, ConstantPool constantPool) throws IOException {
        int tag = classReader.readUnit8();
        ConstantInfo constantInfo = newConstantInfo(tag, classReader, constantPool);
        return constantInfo;
    }

    public static ConstantInfo newConstantInfo(int tag, ClassReader classReader, ConstantPool constantPool){
        switch (tag){
            case ConstantInfo.CONASTANT_Class_info:
                ConstantClassInfo constantClassInfo = new ConstantClassInfo(classReader, constantPool);
                return constantClassInfo;
            case ConstantInfo.CONASTANT_Fieldref_info:
                ConstantFieldrefInfo constantFieldrefInfo = new ConstantFieldrefInfo(classReader, constantPool);
                return constantFieldrefInfo;
            case ConstantInfo.CONSTANT_Methodref_info:
                ConstantMethodrefInfo constantMethodrefInfo = new ConstantMethodrefInfo(classReader, constantPool);
                return constantMethodrefInfo;
            case ConstantInfo.CONASTANT_InterfaceMethodref_info:
                ConstantInterfaceMethodrefInfo constantInterfaceMethodrefInfo = new ConstantInterfaceMethodrefInfo(classReader, constantPool);
                return constantInterfaceMethodrefInfo;
            case ConstantInfo.CONASTANT_String_info:
                ConstantStringInfo constantStringInfo = new ConstantStringInfo(classReader, constantPool);
                return constantStringInfo;
            case ConstantInfo.CONSTANT_Integer_info:
                ConstantIntegerInfo constantIntegerInfo = new ConstantIntegerInfo(classReader, constantPool);
                return constantIntegerInfo;
            case ConstantInfo.CONASTANT_Float_info:
                ConstantFloatInfo constantFloatInfo = new ConstantFloatInfo(classReader, constantPool);
                return constantFloatInfo;
            case ConstantInfo.CONASTANT_Long_info:
                ConstantLongInfo constantLongInfo = new ConstantLongInfo(classReader, constantPool);
                return constantLongInfo;
            case ConstantInfo.CONSTANT_Double_info:
                ConstantDoubleInfo constantDoubleInfo = new ConstantDoubleInfo(classReader, constantPool);
                return constantDoubleInfo;
            case ConstantInfo.CONASTANT_NameAndType_info:
                ConstantNameAndTypeInfo constantNameAndTypeInfo = new ConstantNameAndTypeInfo(classReader, constantPool);
                return constantNameAndTypeInfo;
            case ConstantInfo.CONASTANT_UTF8_info:
                ConstantUTF8Info constantUTF8Info = new ConstantUTF8Info(classReader, constantPool);
                return constantUTF8Info;
            case ConstantInfo.CONSTANT_MethodHandle_info:
                ConstantMethodHandleInfo constantMethodHandleInfo = new ConstantMethodHandleInfo(classReader, constantPool);
                return constantMethodHandleInfo;
            case ConstantInfo.CONASTANT_MethodType_info:
                ConstantMethodTypeInfo constantMethodTypeInfo = new ConstantMethodTypeInfo(classReader, constantPool);
                return constantMethodTypeInfo;
            case ConstantInfo.CONSTANT_InvokeDynamic_info:
                ConstantInvokeDynamicInfo constantInvokeDynamicInfo = new ConstantInvokeDynamicInfo(classReader, constantPool);
                return constantInvokeDynamicInfo;
        }

        return null;
    }

    public ClassReader getClassReader() {
        return classReader;
    }

    public void setClassReader(ClassReader classReader) {
        this.classReader = classReader;
    }

    public ConstantPool getConstantPool() {
        return constantPool;
    }

    public void setConstantPool(ConstantPool constantPool) {
        this.constantPool = constantPool;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
