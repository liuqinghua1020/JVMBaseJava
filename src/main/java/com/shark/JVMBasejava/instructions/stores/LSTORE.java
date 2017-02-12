package com.shark.JVMBasejava.instructions.stores;

import com.shark.JVMBasejava.instructions.base.Index8Instruction;
import com.shark.JVMBasejava.rtda.RTFrame;

/**
 * Created by qinghualiu on 2017/2/12.
 */
public class LSTORE extends Index8Instruction{



    public static void _lstore(RTFrame frame, int index){
        long val = frame.getOperandStack().popLong();
        frame.getLocalVars().setLong(index, val);
    }

    @Override
    public void execute(RTFrame frame) {
        _lstore(frame, this.getIndex());
    }
}
