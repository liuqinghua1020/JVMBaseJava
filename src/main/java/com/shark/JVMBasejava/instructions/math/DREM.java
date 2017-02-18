package com.shark.JVMBasejava.instructions.math;

import com.shark.JVMBasejava.instructions.base.NoOperandsInstruction;
import com.shark.JVMBasejava.rtda.RTFrame;
import com.shark.JVMBasejava.rtda.slot.OperandStack;

/**
 * Created by qinghualiu on 2017/2/18.
 */
public class DREM extends NoOperandsInstruction {
    @Override
    public void execute(RTFrame frame) {
        OperandStack stack = frame.getOperandStack();
        double v2 = stack.popDouble();
        double v1 = stack.popDouble();
        if(v2 == 0){
            throw new ArithmeticException("/ by zero");
        }

        double result = v1 % v2;
        stack.pushDouble(result);
    }
}
