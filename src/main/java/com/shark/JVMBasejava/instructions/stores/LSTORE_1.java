package com.shark.JVMBasejava.instructions.stores;

import com.shark.JVMBasejava.instructions.base.NoOperandsInstruction;
import com.shark.JVMBasejava.rtda.RTFrame;

/**
 * Created by qinghualiu on 2017/2/12.
 */
public class LSTORE_1 extends NoOperandsInstruction {
    @Override
    public void execute(RTFrame frame) {
        LSTORE._lstore(frame, 1);
    }
}
