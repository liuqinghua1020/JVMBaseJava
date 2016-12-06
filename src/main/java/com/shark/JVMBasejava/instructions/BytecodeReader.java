package com.shark.JVMBasejava.instructions;

/**
 * Created by liuqinghua on 16-12-6.
 */
public class BytecodeReader {
    private byte[] code;
    private int pc;

    public void reset(byte[] code, int pc){
        this.code = code;
        this.pc = pc;
    }

    public int readUint8(){
        int i = readInt8();
        int op = i & 0xff;
        return op;
    }

    public int readInt8() {
        byte i = code[pc];
        pc ++;
        return (int)i;
    }

    public int readInt16() {
        int byte1 = this.readUint8();
        int byte2 = this.readUint8();
        return byte1<<8 | byte2;
    }

    public int readUint16(){
        int op = this.readInt16();
        return op & 0xffff;
    }

    public long readInt32(){
        int byte1 = this.readUint8();
        int byte2 = this.readUint8();
        int byte3 = this.readUint8();
        int byte4 = this.readUint8();
        return (byte1 << 24 | byte2 << 16 | byte3 <<8 | byte4);
    }


}
