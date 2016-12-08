package com.shark.JVMBasejava.instructions.loads;

import com.shark.JVMBasejava.instructions.base.NoOperandsInstruction;
import com.shark.JVMBasejava.rtda.RTFrame;

/**
 * Created by liuqinghua on 16-12-8.
 */
public class ILOAD_0 extends NoOperandsInstruction {
    @Override
    public void execute(RTFrame frame) {
        ILOAD._iload(frame, 0);
    }
}
