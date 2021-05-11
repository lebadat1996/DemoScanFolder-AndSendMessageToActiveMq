package com.vsii.scanfolder;

import java.io.File;

public class main {
    public static void main(String[] args) {
        String path = buildFolderPath("E:\\Scan", "folder1");
        System.out.println(path);
    }

    public static String buildFolderPath(String folderParent, String folderChild) {
        return folderParent + File.separatorChar + folderChild;
    }
}
