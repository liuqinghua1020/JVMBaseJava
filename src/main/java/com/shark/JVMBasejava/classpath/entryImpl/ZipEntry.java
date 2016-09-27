package com.shark.JVMBasejava.classpath.entryImpl;

import com.shark.JVMBasejava.classpath.Entry;
import com.shark.JVMBasejava.exception.NoKnowException;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/**
 * Created by liuqinghua on 16-9-24.
 */
public class ZipEntry implements Entry {

    private String absPath;

    public ZipEntry(String path){
        this.absPath = path;
    }

    public byte[] readClass(String className) throws Exception {
        if(StringUtils.isEmpty(absPath)){
            throw new NoKnowException("没有指定ClassLoader加载的jar包");
        }

        JarFile jf = new JarFile(absPath);
        Enumeration<JarEntry> jfs = jf.entries();
        StringBuffer sb  = new StringBuffer();
        while(jfs.hasMoreElements()){
            JarEntry jfn = jfs.nextElement();
            if(jfn.getName().endsWith(className)){
                InputStream is = jf.getInputStream(jfn);
                byte[] classBytes = IOUtils.toByteArray(is);
                return classBytes;
            }
        }

        return null;
    }

    @Override
    public String toString(){
        return "ZipEntry["+absPath+"]";
    }

    public String getAbsPath() {
        return absPath;
    }

    public void setAbsPath(String absPath) {
        this.absPath = absPath;
    }
}
