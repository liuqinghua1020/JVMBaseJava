package com.shark.JVMBasejava.instructions.stack;

import com.shark.JVMBasejava.instructions.base.NoOperandsInstruction;
import com.shark.JVMBasejava.rtda.RTFrame;
import com.shark.JVMBasejava.rtda.slot.OperandStack;
import com.shark.JVMBasejava.rtda.slot.Slot;

/**
 * Created by qinghualiu on 2017/2/12.
 */
public class SWAP extends NoOperandsInstruction {
    @Override
    public void execute(RTFrame frame) {
        OperandStack stack = frame.getOperandStack();
        Slot slot1 = stack.popSlot();
        Slot slot2 = stack.popSlot();
        stack.pushSlot(slot1);
        stack.pushSlot(slot2);
    }
}
