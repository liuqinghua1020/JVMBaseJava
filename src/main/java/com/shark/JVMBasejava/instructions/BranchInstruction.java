package com.shark.JVMBasejava.instructions;

import com.shark.JVMBasejava.rtda.RTFrame;

/**
 * Created by liuqinghua on 16-12-6.
 */
public class BranchInstruction implements Instruction {

    private int offset;
    @Override
    public void fetchOperands(BytecodeReader reader) {
        this.offset = reader.readInt16();
    }

    @Override
    public void execute(RTFrame frame) {

    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }
}
