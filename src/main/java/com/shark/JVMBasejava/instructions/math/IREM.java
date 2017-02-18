package com.shark.JVMBasejava.instructions.math;

import com.shark.JVMBasejava.instructions.base.NoOperandsInstruction;
import com.shark.JVMBasejava.rtda.RTFrame;
import com.shark.JVMBasejava.rtda.slot.OperandStack;

/**
 * Created by qinghualiu on 2017/2/18.
 */
public class IREM extends NoOperandsInstruction {
    @Override
    public void execute(RTFrame frame) {
        OperandStack stack = frame.getOperandStack();
        int v2 = stack.popInt();
        int v1 = stack.popInt();
        if(v2 == 0){
            throw new ArithmeticException("/ by zero");
        }

        int result = v1 % v2;
        stack.pushInt(result);
    }
}
