package com.vsii.scanfolder;

import java.io.File;

public class main {
    public static void main(String[] args) {
//        String path = buildFolderPath("E:\\Scan", "folder1");
//        System.out.println(path);
        String regex = "[a-zA-Z_,.]{0,100}";
        String name = "abcdsadsadnsadaskndasdasdlqweqw";
        System.out.println(name.matches(regex));
    }

    public static String buildFolderPath(String folderParent, String folderChild) {
        return folderParent + File.separatorChar + folderChild;
    }
}
