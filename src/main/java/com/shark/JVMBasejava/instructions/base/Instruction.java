package com.shark.JVMBasejava.instructions.base;

import com.shark.JVMBasejava.rtda.RTFrame;

/**
 * Created by liuqinghua on 16-12-6.
 */
public interface Instruction {
    public void fetchOperands(BytecodeReader reader);
    public void execute(RTFrame frame);
}
