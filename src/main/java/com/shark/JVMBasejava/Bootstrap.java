package com.shark.JVMBasejava;

import com.shark.JVMBasejava.classfile.ClassFile;
import com.shark.JVMBasejava.classpath.ClassPathParser;
import com.shark.JVMBasejava.classpath.Classpath;
import com.shark.JVMBasejava.exception.ConstantPoolException;
import com.shark.JVMBasejava.rtda.RTFrame;
import com.shark.JVMBasejava.rtda.slot.LocalVars;
import com.shark.JVMBasejava.rtda.slot.OperandStack;

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
        /*System.out.println(String.format("classpath:%s, class:%s",
                cmd.getCpOption(), cmd.getClazz()));
        ClassPathParser classPathParser = new ClassPathParser();
        Classpath classpath = classPathParser.parse(cmd.getXjreOption(), cmd.getCpOption());
        String clazz = cmd.getClazz();
        clazz = clazz.replaceAll("\\.", "\\/");
        byte[] clazzData = classpath.readClass(clazz);
        loadClass(clazzData);*/
        RTFrame frame = new RTFrame(100, 100);
        testLocalVars(frame.getLocalVars());
        testOperandStack(frame.getOperandStack());
    }

    private static void loadClass(byte[] clazzData) throws Exception {
        ClassFile cf = ClassFile.parse(clazzData);
        printClassInfo(cf);
    }

    private static void printClassInfo(ClassFile classFile) throws ConstantPoolException {
        System.out.println("version: " + classFile.getMajorVersion() + ":" + classFile.getMinorVersion());
        System.out.println("constants count: " + classFile.getConstantPool().constantsCount());
        System.out.println("access flags: " + classFile.getAccessFlags());
        System.out.println("this class: " + classFile.className());
        System.out.println("super class: " + classFile.superClassName());
        System.out.println("field count " + classFile.getFields().length);
        System.out.println("method count " + classFile.getMethods().length);
    }

    private static void testLocalVars(LocalVars localVars) {
        localVars.setLong(0, Long.MAX_VALUE-1);
        System.out.println("Long Max - 1 :" +  (Long.MAX_VALUE-1));
        System.out.println(localVars.getLong(0));
    }

    private static void testOperandStack(OperandStack operandStack){
        operandStack.pushLong(Long.MAX_VALUE-1);
        System.out.println(operandStack.popLong());
    }
}
