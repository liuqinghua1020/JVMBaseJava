package com.shark.JVMBasejava;

import com.shark.JVMBasejava.classpath.ClassPathParser;
import com.shark.JVMBasejava.classpath.Classpath;

import java.text.Format;

/**
 * Created by liuqinghua on 16-9-10.
 */
public class Bootstrap {
    public static void main(String[] args) throws Exception {
        Cmd cmd = Cmd.parseCmd(args);
        if(cmd == null){
            System.err.println("error java commond");
        }

        if(cmd.isVersionFlag()){
            System.out.println("version 1.0");
        }else if(cmd.isHelpFlag() || cmd.getClazz() == null || "".equals(cmd.getClazz())){
            Cmd.printUsage(System.out);
        }else{
            startJVM(cmd);
        }
    }

    private static void startJVM(Cmd cmd) throws Exception {
        System.out.println(String.format("classpath:%s, class:%s",
                cmd.getCpOption(), cmd.getClazz()));
        ClassPathParser classPathParser = new ClassPathParser();
        Classpath classpath = classPathParser.parse(cmd.getXjreOption(), cmd.getCpOption());
        String clazz = cmd.getClazz();
        clazz = clazz.replaceAll("\\.", "\\/");
        byte[] clazzData = classpath.readClass(clazz);
        System.out.println(clazzData.length);
    }
}
