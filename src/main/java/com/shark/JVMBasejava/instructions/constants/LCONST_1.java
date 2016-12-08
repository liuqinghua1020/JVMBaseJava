package com.shark.JVMBasejava.instructions.constants;

import com.shark.JVMBasejava.instructions.base.NoOperandsInstruction;
import com.shark.JVMBasejava.rtda.RTFrame;

/**
 * Created by liuqinghua on 16-12-8.
 */
public class LCONST_1 extends NoOperandsInstruction {

    @Override
    public void execute(RTFrame frame) {
        frame.getOperandStack().pushLong(1L);
    }
}
