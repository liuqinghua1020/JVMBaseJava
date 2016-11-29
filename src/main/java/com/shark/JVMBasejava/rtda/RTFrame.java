package com.shark.JVMBasejava.rtda;

import com.shark.JVMBasejava.rtda.slot.LocalVars;
import com.shark.JVMBasejava.rtda.slot.OperandStack;

/**
 * Created by liuqinghua on 16-11-8.
 */
public class RTFrame {
    private RTFrame lower;
    private LocalVars localVars;
    private OperandStack operandStack;

    public RTFrame(int maxLocals, int maxStack){
        localVars = new LocalVars(maxLocals);
        operandStack = new OperandStack(maxStack);
    }

    public RTFrame getLower() {
        return lower;
    }

    public void setLower(RTFrame lower) {
        this.lower = lower;
    }

    public LocalVars getLocalVars() {
        return localVars;
    }

    public void setLocalVars(LocalVars localVars) {
        this.localVars = localVars;
    }

    public OperandStack getOperandStack() {
        return operandStack;
    }

    public void setOperandStack(OperandStack operandStack) {
        this.operandStack = operandStack;
    }
}
