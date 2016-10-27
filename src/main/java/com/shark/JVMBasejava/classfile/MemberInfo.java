package com.shark.JVMBasejava.classfile;

import com.shark.JVMBasejava.classfile.attribute.AttributeInfo;

import java.io.IOException;

/**
 * Created by liuqinghua on 16-10-15.
 */
public class MemberInfo {
    private ConstantPool cp;
    private int accessFlags;
    private int nameIndex;
    private int descriptorIndex;
    private AttributeInfo[] attributes;

    private ClassReader classReader;

    private MemberInfo(ClassReader  classReader, ConstantPool cp){
        this.cp = cp;
        this.classReader = classReader;
    }

    public static MemberInfo[] readMembers(ClassReader  classReader, ConstantPool cp) throws Exception {
        int memberCount = classReader.readUnit16();
        MemberInfo[] memberInfos = new MemberInfo[memberCount];
        for(int i=0; i<memberCount;i++){
            memberInfos[i] = readMember(classReader, cp);
        }

        return memberInfos;
    }


    public static MemberInfo readMember(ClassReader  classReader, ConstantPool cp) throws Exception {
        MemberInfo memberInfo = new MemberInfo(classReader, cp);
        memberInfo.setAccessFlags(classReader.readUnit16());
        memberInfo.setNameIndex(classReader.readUnit16());
        memberInfo.setDescriptorIndex(classReader.readUnit16());
        memberInfo.setAttributes(AttributeInfo.readAttributes(classReader, cp));
        return memberInfo;
    }


    public ConstantPool getCp() {
        return cp;
    }

    public void setCp(ConstantPool cp) {
        this.cp = cp;
    }

    public int getAccessFlags() {
        return accessFlags;
    }

    public void setAccessFlags(int accessFlags) {
        this.accessFlags = accessFlags;
    }

    public int getNameIndex() {
        return nameIndex;
    }

    public void setNameIndex(int nameIndex) {
        this.nameIndex = nameIndex;
    }

    public int getDescriptorIndex() {
        return descriptorIndex;
    }

    public void setDescriptorIndex(int descriptorIndex) {
        this.descriptorIndex = descriptorIndex;
    }

    public ClassReader getClassReader() {
        return classReader;
    }

    public void setClassReader(ClassReader classReader) {
        this.classReader = classReader;
    }

    public AttributeInfo[] getAttributes() {
        return attributes;
    }

    public void setAttributes(AttributeInfo[] attributes) {
        this.attributes = attributes;
    }
}
