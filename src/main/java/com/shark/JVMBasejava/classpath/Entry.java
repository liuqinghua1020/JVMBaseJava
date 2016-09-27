package com.shark.JVMBasejava.classpath;

import com.shark.JVMBasejava.classpath.entryImpl.CompositeEntry;
import com.shark.JVMBasejava.classpath.entryImpl.DirEntry;
import com.shark.JVMBasejava.classpath.entryImpl.WildcardEntry;
import com.shark.JVMBasejava.exception.NoKnowException;

/**
 * Created by liuqinghua on 16-9-24.
 */
public interface Entry {
    /**
     * 用于寻找和加载class文件
     * @param className
     * @return
     * @throws NoKnowException
     */
    public byte[] readClass(String className) throws Exception;

    /**
     * 用于构造具体的Entry类
     * @param path  jre的路径
     * @return
     */
    public static Entry newEntry(String path){
        if(path.contains(";")){
            return new CompositeEntry(path);
        }

        if(path.endsWith("\\*")){
            return new WildcardEntry(path);
        }

        return new DirEntry(path);
    }
}
