package com.shark.JVMBasejava.classfile.attribute;

import com.shark.JVMBasejava.classfile.ClassReader;
import com.shark.JVMBasejava.classfile.ConstantPool;

/**
 * Created by liuqinghua on 16-10-20.
 */
public class LineNumberTableAttribute extends AttributeInfo {

    private LineNumberTableEntry[] lineNumberTableEntries;

    public LineNumberTableAttribute(String attrName, int attrLen, ClassReader classReader, ConstantPool constantPool) {
        super(classReader, constantPool, attrName, attrLen);
    }

    @Override
    public void readInfo() throws Exception {
        lineNumberTableEntries = LineNumberTableEntry.readLineNumberTableEntrys(this.getClassReader());
    }

    public LineNumberTableEntry[] getLineNumberTableEntries() {
        return lineNumberTableEntries;
    }

    public void setLineNumberTableEntries(LineNumberTableEntry[] lineNumberTableEntries) {
        this.lineNumberTableEntries = lineNumberTableEntries;
    }
}
