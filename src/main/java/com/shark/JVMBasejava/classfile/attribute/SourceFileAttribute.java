package com.shark.JVMBasejava.classfile.attribute;

import com.shark.JVMBasejava.classfile.ClassReader;
import com.shark.JVMBasejava.classfile.ConstantPool;
import com.shark.JVMBasejava.exception.ConstantPoolException;

/**
 * Created by liuqinghua on 16-10-20.
 */
public class SourceFileAttribute extends AttributeInfo {

    private int sourceFileIndex;

    public SourceFileAttribute(String attrName, int attrLen, ClassReader classReader, ConstantPool constantPool) {
        super(classReader, constantPool, attrName, attrLen);
    }

    @Override
    public void readInfo() throws Exception {
        this.sourceFileIndex = this.getClassReader().readUnit16();
    }

    public int getSourceFileIndex() {
        return sourceFileIndex;
    }

    public void setSourceFileIndex(int sourceFileIndex) {
        this.sourceFileIndex = sourceFileIndex;
    }

    public String sourceFileName() throws ConstantPoolException {
        return this.getConstantPool().getUTF8(this.sourceFileIndex);
    }
}
