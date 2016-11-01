package com.shark.JVMBasejava.classfile.attribute;

import com.shark.JVMBasejava.classfile.ClassReader;
import com.shark.JVMBasejava.classfile.ConstantPool;

/**
 * Created by liuqinghua on 16-10-20.
 */
public class LocalVariableTableAttribute extends AttributeInfo {

    private LocalVariableTableEntry[] localVariableTableEntry;

    public LocalVariableTableAttribute(String attrName, int attrLen, ClassReader classReader, ConstantPool constantPool) {
        super(classReader, constantPool, attrName, attrLen);
    }

    @Override
    public void readInfo() throws Exception {
        localVariableTableEntry = LocalVariableTableEntry.readLocalVariableTableEntrys(this.getClassReader());
    }

    public LocalVariableTableEntry[] getLocalVariableTableEntry() {
        return localVariableTableEntry;
    }

    public void setLocalVariableTableEntry(LocalVariableTableEntry[] localVariableTableEntry) {
        this.localVariableTableEntry = localVariableTableEntry;
    }
}
