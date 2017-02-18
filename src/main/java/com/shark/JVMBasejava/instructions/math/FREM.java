package com.shark.JVMBasejava.instructions.math;

import com.shark.JVMBasejava.instructions.base.NoOperandsInstruction;
import com.shark.JVMBasejava.rtda.RTFrame;
import com.shark.JVMBasejava.rtda.slot.OperandStack;

/**
 * Created by qinghualiu on 2017/2/18.
 */
public class FREM extends NoOperandsInstruction{
    @Override
    public void execute(RTFrame frame) {
        OperandStack stack = frame.getOperandStack();
        float v2 = stack.popFloat();
        float v1 = stack.popFloat();
        if(v2 == 0){
            throw new ArithmeticException("/ by zero");
        }

        float result = v1 % v2;
        stack.pushFloat(result);
    }
}
