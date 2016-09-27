package com.shark.JVMBasejava.classpath.entryImpl;

import com.shark.JVMBasejava.classpath.Entry;
import com.shark.JVMBasejava.exception.NoKnowException;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.File;

/**
 * Created by liuqinghua on 16-9-24.
 */
public class DirEntry implements Entry{

    private String absDir;

    public DirEntry(String path){
        this.absDir = path;
    }

    public byte[] readClass(String className) throws Exception {
        if(StringUtils.isEmpty(absDir)){
            throw new NoKnowException("没有指定ClassLoader加载的jre目录");
        }

        String clazz = FilenameUtils.concat(absDir, className);
        byte[] classBytes = FileUtils.readFileToByteArray(new File(clazz));
        return classBytes;
    }


    public String getAbsDir() {
        return absDir;
    }

    public void setAbsDir(String absDir) {
        this.absDir = absDir;
    }

    @Override
    public String toString(){
        return "DirEntry[" + absDir + "]";
    }
}
