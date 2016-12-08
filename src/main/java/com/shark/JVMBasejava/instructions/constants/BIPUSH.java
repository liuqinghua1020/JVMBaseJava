package com.shark.JVMBasejava.instructions.constants;

import com.shark.JVMBasejava.instructions.base.BytecodeReader;
import com.shark.JVMBasejava.instructions.base.Instruction;
import com.shark.JVMBasejava.rtda.RTFrame;

/**
 * Created by liuqinghua on 16-12-8.
 */
public class BIPUSH implements Instruction{

    private int val;

    @Override
    public void fetchOperands(BytecodeReader reader) {
        this.val = reader.readInt8();
    }

    @Override
    public void execute(RTFrame frame) {
        frame.getOperandStack().pushInt(this.val);
    }
}
