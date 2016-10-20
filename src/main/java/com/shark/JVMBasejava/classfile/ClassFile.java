package com.shark.JVMBasejava.classfile;

import com.shark.JVMBasejava.classfile.attribute.AttributeInfo;
import com.shark.JVMBasejava.exception.ClassParseException;

import java.io.IOException;

/**
 * Created by liuqinghua on 16-10-11.
 */
public class ClassFile {
    private int magic;
    private int minorVersion;
    private int majorVersion;
    private ConstantPool constantPool;
    private int accessFlags;
    private int thisClass;
    private int superClass;
    private int[] interfaces;
    private MemberInfo[] fields;
    private MemberInfo[] methods;
    private AttributeInfo attributeInfo;

    private ClassReader classReader = null;

    public ClassFile(ClassReader classReader){
        this.classReader = classReader;
    }

    public static ClassFile parse(byte[] classData) throws Exception{
        ClassReader classReader = new ClassReader(classData);
        ClassFile cf = new ClassFile(classReader);
        return cf;
    }

    public void read() throws Exception{
        if(classReader == null){
            throw new Exception("ClassReader init fail");
        }
        this.readAndCheckMagic();
        this.readAndCheckVersion();
        //TODO constantPool
        this.constantPool = null;
        this.accessFlags = classReader.readUnit16();
        this.thisClass = classReader.readUnit16();
        this.superClass = classReader.readUnit16();
        this.interfaces = classReader.readUnit16s();
        //TODO fields
        this.fields = null;
        //TODO methods
        this.methods = null;
        // TODO attributeInfo
        this.attributeInfo = null ;
    }


    public void readAndCheckMagic() throws IOException, ClassParseException {
        this.magic = classReader.readUnit32();
        if(this.magic != 0xCAFEBABE){
            throw new ClassParseException("java.lang.ClassFormatError:magic");
        }
    }

    public void readAndCheckVersion() throws IOException {
        this.minorVersion = classReader.readUnit16();
        this.majorVersion = classReader.readUnit16();
        switch (this.majorVersion){
            case 45:
                return;
            case 46:
            case 47:
            case 48:
            case 49:
            case 50:
            case 51:
            case 52:
                if(this.minorVersion == 0){
                    return;
                }
        }

        throw new UnsupportedClassVersionError();
    }

    public int getMagic() {
        return magic;
    }

    public void setMagic(int magic) {
        this.magic = magic;
    }

    public int getMinorVersion() {
        return minorVersion;
    }

    public void setMinorVersion(int minorVersion) {
        this.minorVersion = minorVersion;
    }

    public int getMajorVersion() {
        return majorVersion;
    }

    public void setMajorVersion(int majorVersion) {
        this.majorVersion = majorVersion;
    }

    public int getAccessFlags() {
        return accessFlags;
    }

    public void setAccessFlags(int accessFlags) {
        this.accessFlags = accessFlags;
    }

    public int getThisClass() {
        return thisClass;
    }

    public void setThisClass(int thisClass) {
        this.thisClass = thisClass;
    }

    public int getSuperClass() {
        return superClass;
    }

    public void setSuperClass(int superClass) {
        this.superClass = superClass;
    }

    public int[] getInterfaces() {
        return interfaces;
    }

    public void setInterfaces(int[] interfaces) {
        this.interfaces = interfaces;
    }
}
