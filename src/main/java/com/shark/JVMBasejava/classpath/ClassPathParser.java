package com.shark.JVMBasejava.classpath;

/**
 * Created by liuqinghua on 16-9-24.
 */
public class ClassPathParser {
    public Classpath parse(String xjreOption, String cpOption) {
        Classpath classpath = Classpath.parseClassPath(xjreOption, cpOption);
        return classpath;
    }
}
