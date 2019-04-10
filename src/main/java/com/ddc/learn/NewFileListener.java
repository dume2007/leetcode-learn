package com.ddc.learn;

import org.apache.commons.io.filefilter.FileFilterUtils;
import org.apache.commons.io.filefilter.IOFileFilter;
import org.apache.commons.io.monitor.FileAlterationListenerAdaptor;
import org.apache.commons.io.monitor.FileAlterationMonitor;
import org.apache.commons.io.monitor.FileAlterationObserver;

import java.io.File;

/**
 * 监听文件变化
 */
public class NewFileListener extends FileAlterationListenerAdaptor {

    @Override
    public void onFileCreate(File file) {
        super.onFileCreate(file);
        System.out.println("新文件被创建" + "：" + file.getPath());
        SyncFile.copyFileToDest(file);
    }

    public static void main(String[] args) {
        File dir = new File(SyncFile.aPath);
        FileAlterationMonitor monitor = new FileAlterationMonitor();

        IOFileFilter filter = FileFilterUtils.or(FileFilterUtils.directoryFileFilter(),FileFilterUtils.fileFileFilter());

        FileAlterationObserver observer = new FileAlterationObserver(dir, filter);
        observer.addListener(new NewFileListener());

        monitor.addObserver(observer);
        try {
            //开始监听
            monitor.start();
            System.out.println("监听新文件创建……");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
