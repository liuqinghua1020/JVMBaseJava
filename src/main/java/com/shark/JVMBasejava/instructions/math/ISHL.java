package com.shark.JVMBasejava.instructions.math;

import com.shark.JVMBasejava.instructions.base.NoOperandsInstruction;
import com.shark.JVMBasejava.rtda.RTFrame;
import com.shark.JVMBasejava.rtda.slot.OperandStack;

/**
 * Created by qinghualiu on 2017/2/18.
 */
public class ISHL extends NoOperandsInstruction {
    @Override
    public void execute(RTFrame frame) {
        OperandStack stack = frame.getOperandStack();
        int v2 = stack.popInt();
        int v1 = stack.popInt();
        int s = (v2&0x0FFFFFFFF) & 0x1f;
        int result = v1 << s;
        stack.pushInt(result);

    }
}
