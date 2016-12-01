package com.shark.JVMBasejava.rtda.slot;

/**
 * Created by liuqinghua on 16-11-29.
 */
public class LocalVars {

    private Slot[] slots;

    public LocalVars(int maxLocals){
        slots = new Slot[maxLocals];
        for(int i=0;i<maxLocals;i++){
            slots[i] = new Slot();
        }
    }

    public void setInt(int index, int value){
        slots[index].setNum(value);
    }

    public int getInt(int index){
        return slots[index].getNum();
    }

    public void setFloat(int index, float value){
        int num = Float.floatToIntBits(value);
        slots[index].setNum(num);
    }

    public float getFloat(int index){
        int num = slots[index].getNum();
        return Float.intBitsToFloat(num);
    }

    public void setLong(int index, long value){
        slots[index].setNum((int) (0xFFFFFFFFl & value));
        slots[index + 1].setNum((int) ((0xFFFFFFFF00000000l & value) >> 32));
    }

    public long getLong(int index){
        int low = slots[index].getNum();
        int high = slots[index + 1].getNum();
        long result = ((long)low & 0xFFFFFFFFl) | (((long)high << 32) & 0xFFFFFFFF00000000l);
        return result;
    }

    public void setDouble(int index, double value){
        long num = Double.doubleToLongBits(value);
        this.setLong(index, num);
    }

    public Double getDouble(int index){
        long num = this.getLong(index);
        return Double.longBitsToDouble(num);
    }

    public void setRef(int index, Object ref){
        slots[index].setRef(ref);
    }

    public Object getRef(int index){
        return slots[index].getRef();
    }
}
