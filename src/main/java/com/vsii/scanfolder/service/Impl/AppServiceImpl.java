package com.vsii.scanfolder.service.Impl;

import com.vsii.scanfolder.Util.JmsUtils;
import com.vsii.scanfolder.config.PropertyConfig;
import com.vsii.scanfolder.service.AppServiceScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class AppServiceImpl implements AppServiceScan {
    @Autowired
    ValidateServiceImpl validateService;
    @Autowired
    PropertyConfig config;
    @Autowired
    JmsUtils jmsUtils;

    @Override
    public void scanFolder(String queueName) {
        try {
            System.out.println(config.getFolderScan() + " parent");
            System.out.println(config.getFolderChildren() + " children");
            String pathFolderScan = buildFolderPath(config.getFolderScan(), config.getFolderChildren());
            File folder = new File(pathFolderScan);
            File[] listOfFiles = folder.listFiles();
            for (int i = 0; i < listOfFiles.length; i++) {
                if (listOfFiles[i].isFile()) {
                    System.out.println("File " + listOfFiles[i].getName());
                } else if (listOfFiles[i].isDirectory()) {
                    System.out.println("Directory " + listOfFiles[i].getName());
                    boolean validateNameFolder = validateNameFolder(listOfFiles[i].getName(), "[a-zA-Z_,.]{0,100}");
                    if (validateNameFolder) {
                        System.out.println("validate thanh cong");
                        jmsUtils.sendFolderUrlMessage(listOfFiles[i].getAbsolutePath(), "queueScan");
                    } else {
                        System.out.println("validate khong thanh cong");
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String buildFolderPath(String folderParent, String folderChild) {
        return folderParent + File.separatorChar + folderChild;
    }

    public static boolean validateNameFolder(String folderName, String regex) {
        if (folderName.matches(regex)) {
            return true;
        } else {
            return false;
        }
    }


    public static void main(String[] args) {
        String pathFolderScan = buildFolderPath("D:\\Scan", "folder1");
        System.out.println("Name: " + pathFolderScan);
        File folder = new File(pathFolderScan);
        File[] listOfFiles = folder.listFiles();
        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile()) {
                System.out.println("File " + listOfFiles[i].getName());
            } else if (listOfFiles[i].isDirectory()) {
                System.out.println("Directory " + listOfFiles[i].getName());
                boolean validateNameFolder = validateNameFolder(listOfFiles[i].getName(), "[a-zA-Z_,.]{0,100}");
                if (validateNameFolder) {
                    System.out.println("validate thanh cong");
                } else {
                    System.out.println("validate khong thanh cong");
                }
            }
        }
    }
}

