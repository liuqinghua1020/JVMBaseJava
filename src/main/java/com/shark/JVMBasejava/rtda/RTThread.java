package com.shark.JVMBasejava.rtda;

/**
 * Created by liuqinghua on 16-11-8.
 */
public class RTThread {

    private int pc;
    private RTStack stack;

    public RTThread(int pc, RTStack stack){
        this.pc = pc;
        this.stack = stack;
    }

    public void pushFrame(RTFrame frame){
        stack.push(frame);
    }

    public RTFrame popFrame(){
        return stack.popFrame();
    }

    public RTFrame currentFrame(){
        return stack.topFrame();
    }

    public int getPc() {
        return pc;
    }

    public void setPc(int pc) {
        this.pc = pc;
    }

    public RTStack getStack() {
        return stack;
    }

    public void setStack(RTStack stack) {
        this.stack = stack;
    }
}
