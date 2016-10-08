package com.shark.JVMBasejava.classpath.entryImpl;

import com.shark.JVMBasejava.classpath.Entry;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.AndFileFilter;
import org.apache.commons.io.filefilter.FileFilterUtils;
import org.apache.commons.io.filefilter.IOFileFilter;
import org.apache.commons.io.filefilter.OrFileFilter;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * 通配符Entry，其实只也是一个CompositeEntry
 * Created by liuqinghua on 16-9-25.
 */
public class WildcardEntry extends  CompositeEntry{

    public WildcardEntry(String path) {
        String baseDir = null;
        if(path.charAt(path.length()-1) == '*') {
            baseDir = path.substring(0, path.length() - 1);
        }else{
            baseDir = path;
        }

        List<IOFileFilter> fileFilters = new ArrayList<>();
        fileFilters.add(FileFilterUtils.suffixFileFilter("jar"));
        fileFilters.add(FileFilterUtils.suffixFileFilter("JAR"));

        Collection<File> files = FileUtils.listFiles(new File(baseDir), new OrFileFilter(fileFilters), null);
        for(File file:files){
            Entry entry = new ZipEntry(file.getAbsolutePath());
            this.list.add(entry);
        }

    }
}
