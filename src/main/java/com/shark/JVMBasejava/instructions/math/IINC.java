package com.shark.JVMBasejava.instructions.math;

import com.shark.JVMBasejava.instructions.base.BytecodeReader;
import com.shark.JVMBasejava.instructions.base.Instruction;
import com.shark.JVMBasejava.rtda.RTFrame;
import com.shark.JVMBasejava.rtda.slot.LocalVars;

/**
 * Created by qinghualiu on 2017/2/18.
 */
public class IINC implements Instruction {

    private int index;
    private int constVal;

    @Override
    public void fetchOperands(BytecodeReader reader) {
        this.index = reader.readUint8();
        this.constVal = reader.readInt8();
    }

    @Override
    public void execute(RTFrame frame) {
        LocalVars localVars = frame.getLocalVars();
        int value = localVars.getInt(this.getIndex());
        value += this.getConstVal();
        localVars.setInt(this.getIndex(), value);
    }

    public int getConstVal() {
        return constVal;
    }

    public void setConstVal(int constVal) {
        this.constVal = constVal;
    }

    public int getIndex() {

        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
