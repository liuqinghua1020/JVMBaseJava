package com.shark.JVMBasejava.classfile;

import java.io.ByteArrayInputStream;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.IOException;

/**
 * Created by liuqinghua on 16-10-11.
 */
public class ClassReader {
    private byte[] data;
    private DataInputStream dataInput;

    public ClassReader(byte[] data){
        this.data = data;
        this.dataInput = new DataInputStream(new ByteArrayInputStream(data));
    }

    public int readUnit8() throws IOException{

        return dataInput.readUnsignedByte();

    }

    public int readUnit16() throws IOException{

        return dataInput.readUnsignedShort();

    }

    public int readUnit32() throws IOException{
        return dataInput.readInt();

    }

    public long readUnit64() throws IOException {

        return dataInput.readLong();

    }

    public int[] readUnit16s() throws IOException{
        int length = this.readUnit16();
        int[] s = new int[length];
        for(int i=0;i<length;i++){
            s[i] = this.readUnit16();
        }
        return s;
    }

    public byte[] readBytes(int n) throws IOException{
        byte[] bytes = new byte[n];
        for(int i=0;i<n;i++){
            bytes[i] =  new Integer(this.dataInput.readUnsignedByte()).byteValue();

        }

        return bytes;
    }

    public String readUTF8() throws IOException{
        return this.dataInput.readUTF();
    }
}
