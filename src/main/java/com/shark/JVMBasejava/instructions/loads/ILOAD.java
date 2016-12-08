package com.shark.JVMBasejava.instructions.loads;

import com.shark.JVMBasejava.instructions.base.Index8Instruction;
import com.shark.JVMBasejava.rtda.RTFrame;

/**
 * Created by liuqinghua on 16-12-8.
 */
public class ILOAD extends Index8Instruction {
    @Override
    public void execute(RTFrame frame) {
         _iload(frame, this.getIndex());
    }

    public static void _iload(RTFrame frame, int index){
        int val = frame.getLocalVars().getInt(index);
        frame.getOperandStack().pushInt(val);
    }
}
