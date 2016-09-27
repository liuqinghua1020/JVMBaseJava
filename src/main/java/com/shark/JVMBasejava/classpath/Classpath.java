package com.shark.JVMBasejava.classpath;

import com.shark.JVMBasejava.classpath.entryImpl.WildcardEntry;
import org.apache.commons.compress.compressors.FileNameUtil;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.File;

/**
 * Created by liuqinghua on 16-9-24.
 */
public class Classpath {

    private Entry bootClasspath;
    private Entry extClasspath;
    private Entry userClasspath;

    public static Classpath parseClassPath(String jreOption, String cpOption){
        Classpath classpath = new Classpath();
        classpath.parseBootAndExtClasspath(jreOption);
        classpath.parseUserClasspath(cpOption);
        return classpath;
    }

    private void parseBootAndExtClasspath(String jreOption) {
        String jreDir = this.getJreDir(jreOption);

        String jreLibPath = jreDir + "lib/*"; //jre/lib/*
        this.bootClasspath = new WildcardEntry(jreLibPath);

        String jreExtPath = jreDir + "lib/ext/*"; //jre/lib/ext/*
        this.extClasspath = new WildcardEntry(jreExtPath);
    }

    /**
     * 1.如果jreOption不为空，则在该命令下找lib
     * 2.否则在当前目录下找
     * 3.再不存在，则在 JAVA_HOME目录下找
     * @param jreOption
     * @return
     */
    private String getJreDir(String jreOption) {
        if(!StringUtils.isEmpty(jreOption) && new File(jreOption).isDirectory()){
            return jreOption;
        }

        if(new File("./jre").isDirectory()){
            return "./jre";
        }

        String java_home = System.getenv("JAVA_HOME");
        if(!StringUtils.isEmpty(java_home) && new File(java_home).isDirectory()){
            return java_home + "/jre";
        }

        return null;
    }

    private void parseUserClasspath(String cpOption){
        if(StringUtils.isEmpty(cpOption)){
            cpOption = ".";
        }

        this.userClasspath = Entry.newEntry(cpOption);
    }

    public byte[] readClass(String className) throws Exception {
        className += ".class";
        byte[] data = bootClasspath.readClass(className);
        if(data != null){
            return data;
        }

        data = extClasspath.readClass(className);
        if(data != null){
            return data;
        }

        return userClasspath.readClass(className);

    }

    @Override
    public String toString(){
        return userClasspath.toString();
    }

    public Entry getBootClasspath() {
        return bootClasspath;
    }

    public void setBootClasspath(Entry bootClasspath) {
        this.bootClasspath = bootClasspath;
    }

    public Entry getExtClasspath() {
        return extClasspath;
    }

    public void setExtClasspath(Entry extClasspath) {
        this.extClasspath = extClasspath;
    }

    public Entry getUserClasspath() {
        return userClasspath;
    }

    public void setUserClasspath(Entry userClasspath) {
        this.userClasspath = userClasspath;
    }
}
