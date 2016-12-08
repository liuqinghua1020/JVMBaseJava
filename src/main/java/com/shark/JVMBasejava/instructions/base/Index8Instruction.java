package com.shark.JVMBasejava.instructions.base;

import com.shark.JVMBasejava.rtda.RTFrame;

/**
 * Created by liuqinghua on 16-12-6.
 */
public class Index8Instruction implements Instruction {
    private int index;
    @Override
    public void fetchOperands(BytecodeReader reader) {
        this.index = reader.readUint8();
    }

    @Override
    public void execute(RTFrame frame) {

    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
