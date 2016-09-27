package com.shark.JVMBasejava.classpath.entryImpl;

import com.shark.JVMBasejava.classpath.Entry;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by liuqinghua on 16-9-25.
 */
public class CompositeEntry implements Entry {

    protected List<Entry> list = null;

    public CompositeEntry(){}

    public CompositeEntry(String pathList){
        list = new ArrayList<>();

        String[] paths = pathList.split(File.separator);
        for(String path:paths){
            Entry entry = Entry.newEntry(path);
            list.add(entry);
        }
    }

    @Override
    public byte[] readClass(String className) throws Exception {
        for(Entry entry:list){
            byte[] classBytes = entry.readClass(className);
            if(classBytes != null && classBytes.length > 0){
                return classBytes;
            }
        }

        return null;
    }

    @Override
    public String toString(){
        StringBuffer stringBuffer = new StringBuffer();
        for(Entry entry:list){
            stringBuffer.append(entry.toString()).append(File.separator);
        }
        return stringBuffer.substring(0, stringBuffer.length()-1).toString();

    }
}
