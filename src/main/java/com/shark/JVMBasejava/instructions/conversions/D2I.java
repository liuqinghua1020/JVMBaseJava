package com.shark.JVMBasejava.instructions.conversions;

import com.shark.JVMBasejava.instructions.base.NoOperandsInstruction;
import com.shark.JVMBasejava.rtda.RTFrame;
import com.shark.JVMBasejava.rtda.slot.OperandStack;

/**
 * Created by qinghualiu on 2017/2/18.
 */
public class D2I extends NoOperandsInstruction {
    @Override
    public void execute(RTFrame frame) {
        OperandStack stack = frame.getOperandStack();
        double val = stack.popDouble();

        int intVal = new Double(val).intValue();

        stack.pushInt(intVal);
    }
}
