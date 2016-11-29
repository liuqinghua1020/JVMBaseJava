package com.shark.JVMBasejava.rtda;

import java.util.Stack;

/**
 * Created by liuqinghua on 16-11-8.
 */
public class RTStack {

    private int maxSize;
    private int size;
    private RTFrame top;


    public RTStack(int maxSize){
        this.maxSize = maxSize;
        this.size = 0;

    }

    public void push(RTFrame frame){
        if(size > maxSize){
            throw new RuntimeException("堆栈已经超过最大限制 size: " + size + "; maxSize:" + maxSize);
        }

        if(this.top != null){
            frame.setLower(this.top);
        }
        this.top = frame;
        size ++;
    }

    public RTFrame popFrame() throws Exception {
        if(this.top == null){
            throw new Exception("jvm stack is empty");
        }
        RTFrame frame = this.top;
        this.top = frame.getLower();
        frame.setLower(null);
        this.size --;
        return frame;
    }

    public RTFrame topFrame() throws Exception {
        if(this.top == null){
            throw new Exception("jvm stack is empty");
        }
        return this.top;
    }
}
