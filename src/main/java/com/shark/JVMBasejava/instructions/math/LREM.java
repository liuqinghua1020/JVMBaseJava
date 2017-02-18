package com.shark.JVMBasejava.instructions.math;

import com.shark.JVMBasejava.instructions.base.NoOperandsInstruction;
import com.shark.JVMBasejava.rtda.RTFrame;
import com.shark.JVMBasejava.rtda.slot.OperandStack;

/**
 * Created by qinghualiu on 2017/2/18.
 */
public class LREM extends NoOperandsInstruction{
    @Override
    public void execute(RTFrame frame) {
        OperandStack stack = frame.getOperandStack();
        long v2 = stack.popLong();
        long v1 = stack.popLong();
        if(v2 == 0){
            throw new ArithmeticException("/ by zero");
        }

        long result = v1 % v2;
        stack.pushLong(result);
    }
}
