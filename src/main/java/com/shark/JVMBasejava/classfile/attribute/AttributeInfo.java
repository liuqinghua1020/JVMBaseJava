package com.shark.JVMBasejava.classfile.attribute;

import com.shark.JVMBasejava.classfile.ClassReader;
import com.shark.JVMBasejava.classfile.ConstantPool;
import com.shark.JVMBasejava.exception.ConstantPoolException;
import sun.java2d.pipe.AATextRenderer;

import java.io.IOException;

/**
 * Created by liuqinghua on 16-10-15.
 */
public abstract class AttributeInfo{

    private ClassReader classReader;
    private ConstantPool constantPool;
    private String attrName;
    private int attrLen;

    public AttributeInfo(ClassReader classReader, ConstantPool constantPool, String attrName, int attrLen){
        this.classReader = classReader;
        this.constantPool = constantPool;
        this.attrName = attrName;
        this.attrLen = attrLen;
    }

    public static AttributeInfo[] readAttributes(ClassReader classReader, ConstantPool constantPool) throws Exception {
        int attributeInfoCount = classReader.readUnit16();
        AttributeInfo[] attributeInfos = new AttributeInfo[attributeInfoCount];
        for(int i=0;i<attributeInfoCount;i++){
            attributeInfos[i] = readAttribute(classReader, constantPool);
        }

        return attributeInfos;
    }


    public static AttributeInfo readAttribute(ClassReader classReader, ConstantPool constantPool) throws Exception {
        int attrNameIndex = classReader.readUnit16();
        String attrName = constantPool.getUTF8(attrNameIndex);
        int attrLen = classReader.readUnit32();
        AttributeInfo attributeInfo = newAttributeInfo(attrName, attrLen, classReader, constantPool);
        attributeInfo.readInfo();
        return attributeInfo;
    }

    private static AttributeInfo newAttributeInfo(String attrName, int attrLen, ClassReader classReader, ConstantPool constantPool) {
        switch (attrName){
            case "Code":
                return new CodeAttribute(attrName, attrLen, classReader, constantPool);
            case "ConstantValue":
                return new ConstantValueAttribute(attrName, attrLen, classReader, constantPool);
            case "Deprecated":
                return new DeprecatedAttribute(attrName, attrLen, classReader, constantPool);
            case "Exception":
                return new ExceptionAttribute(attrName, attrLen, classReader, constantPool);
            case "LineNumberTable":
                return new LineNumberTableAttribute(attrName, attrLen, classReader, constantPool);
            case "LocalVariableTable":
                return new LocalVariableTableAttribute(attrName, attrLen, classReader, constantPool);
            case "SourceFile":
                return new SourceFileAttribute(attrName, attrLen, classReader, constantPool);
            case "Synthetic":
                return new SyntheticAttribute(attrName, attrLen, classReader, constantPool);
            default:
                return new UnparsedAttribute(attrName, attrLen, classReader, constantPool);
        }
    }

    public abstract  void readInfo() throws Exception ;

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

    public String getAttrName() {
        return attrName;
    }

    public void setAttrName(String attrName) {
        this.attrName = attrName;
    }

    public int getAttrLen() {
        return attrLen;
    }

    public void setAttrLen(int attrLen) {
        this.attrLen = attrLen;
    }
}
