package com.ddc.learn;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

/**
 * 一次性同步所有文件
 */
public class SyncFile {
    private static List<File> fileList = new ArrayList<>();
    static final String aPath = "/home/dume/a/";
    static final String bPath = "/home/dume/b/";

    public static void main(String[] args) {
        fileList.clear();

        getFileList(aPath);
        System.out.println(fileList.toString());
        copyFileList();
    }

    private static void getFileList(String strPath) {
        File dir = new File(strPath);
        File[] files = dir.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    getFileList(file.getAbsolutePath());
                } else {
                    fileList.add(file);
                }
            }
        }
    }

    private static void copyFileList() {
        if (fileList.size() > 0) {
            for (File file : fileList) {
                copyFileToDest(file);
            }
        }
    }

    static void copyFileToDest(File sourceFile) {
        String sourceFilepath = sourceFile.getAbsolutePath();
        String newFilename = sourceFilepath.replaceFirst(aPath, "");
        String newFilePath = bPath + newFilename.replace("/", "_");

        try {
            File newFile = new File(newFilePath);
            if (!newFile.exists()) {
                Files.copy(sourceFile.toPath(), new File(newFilePath).toPath());
                System.out.println(newFilePath);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
