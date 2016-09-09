package com.shark.JVMBasejava;

import java.text.Format;

/**
 * Created by liuqinghua on 16-9-10.
 */
public class Startup {
    public static void main(String[] args){
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

    private static void startJVM(Cmd cmd) {
        System.out.println(String.format("classpath:%s, class:%s, args:%v",
                cmd.getCpOption(), cmd.getClazz(), cmd.getArgs().toArray()));
    }
}
