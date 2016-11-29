package com.shark.JVMBasejava.rtda.slot;

import java.util.DoubleSummaryStatistics;

/**
 * Created by liuqinghua on 16-11-29.
 */
public class OperandStack {
    private int size;
    private Slot[] slots;

    public OperandStack(int maxStack){
        if(maxStack > 0){
            slots = new Slot[maxStack];
        }
    }

    public void pushInt(int value){
        this.slots[this.size].setNum(value);
        this.size ++;
    }

    public int popInt(){
        this.size --;
        return this.slots[this.size].getNum();
    }

    public void pushFloat(float value){
        int num = Float.floatToIntBits(value);
        this.pushInt(num);
    }

    public float popFloat(){
        int num = this.popInt();
        return Float.intBitsToFloat(num);
    }

    public void pushLong(long value){
        this.slots[this.size].setNum((int)value);
        this.slots[this.size+1].setNum((int)(value>>32));
        this.size += 2;
    }

    public long popLong(){
        this.size -= 2;
        int low = this.slots[this.size].getNum();
        int high = this.slots[this.size+1].getNum();
        return (long)(high << 32 | low);
    }

    public void pushDouble(double value){
        long num = Double.doubleToLongBits(value);
        this.pushLong(num);
    }

    public double popDouble(){
        long num = this.popLong();
        return Double.longBitsToDouble(num);
    }

    public void pushRef(Object ref){
        this.slots[this.size].setRef(ref);
        this.size ++;
    }

    public Object popRef(){
        this.size --;
        return this.slots[this.size].getRef();
    }
}
