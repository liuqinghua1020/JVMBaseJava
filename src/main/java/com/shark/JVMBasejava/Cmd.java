package com.shark.JVMBasejava;

import org.apache.commons.cli.*;

import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by liuqinghua on 16-9-9.
 */
public class Cmd {
    private boolean helpFlag;
    private boolean versionFlag;
    private String cpOption;
    private String XjreOption;
    private String clazz;
    private List<String> args;

    public boolean isHelpFlag() {
        return helpFlag;
    }

    public void setHelpFlag(boolean helpFlag) {
        this.helpFlag = helpFlag;
    }

    public boolean isVersionFlag() {
        return versionFlag;
    }

    public void setVersionFlag(boolean versionFlag) {
        this.versionFlag = versionFlag;
    }

    public String getCpOption() {
        return cpOption;
    }

    public void setCpOption(String cpOption) {
        this.cpOption = cpOption;
    }

    public String getClazz() {
        return clazz;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
    }

    public List<String> getArgs() {
        return args;
    }

    public void setArgs(List<String> args) {
        this.args = args;
    }

    public static Cmd parseCmd(String[] args) {
        Cmd cmd = null;
        try {
            cmd = new Cmd();
            CommandLineParser parser = new DefaultParser();
            Options options = new Options();
            options.addOption("help", false, "print help message");
            options.addOption("?", false, "print help message");
            options.addOption("version", false, "print version and exit");
            options.addOption("classpath", true, "classpath");
            options.addOption("cp", true, "classpath");
            options.addOption("Xjre", false, "path to jre ");

            CommandLine line = parser.parse(options, args);

            if (line.hasOption("help") || line.hasOption("?")) {
                cmd.setHelpFlag(true);
            }

            if (line.hasOption("version")) {
                cmd.setVersionFlag(true);
            }

            if (line.hasOption("classpath")) {
                cmd.setCpOption(line.getOptionValue("classpath"));
            }

            if (line.hasOption("cp")) {
                if (cmd.getCpOption() != null) {
                    cmd.setCpOption(cmd.getCpOption() + " " + line.getOptionValue("cp"));
                } else {
                    cmd.setCpOption(line.getOptionValue("cp"));
                }
            }

            if(line.hasOption("Xjre")){
                cmd.setXjreOption(line.getOptionValue("Xjre"));
            }

            String[] restArgs = line.getArgs();
            if (restArgs != null && restArgs.length >= 1) {
                cmd.setClazz(restArgs[0]);
                List<String> restArg = new ArrayList<String>();
                for (int i = 1; i < restArgs.length; i++) {
                    restArg.add(restArgs[i]);
                }
                cmd.setArgs(restArg);
            }
        }catch(ParseException e){
            e.fillInStackTrace();
            System.err.println("error java commond");
        }
        return cmd;
    }


    public static void printUsage(PrintStream out){
        out.println("Usage: java [-option] class [args...]");
    }

    public void setXjreOption(String xjreOption) {
        XjreOption = xjreOption;
    }

    public String getXjreOption() {
        return XjreOption;
    }
}
