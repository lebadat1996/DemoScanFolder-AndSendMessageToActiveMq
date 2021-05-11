package com.vsii.scanfolder.service.Impl;

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

    @Override
    public void scanFolder(String folderName, String queueName) {
        boolean validateNameFolder = validateService.validateNameFolder(folderName, "[a-zA-Z_,.]{0,100}]");
        String pathFolderScan = buildFolderPath(config.getFolderScan(), config.getFolderChildren());
        File folder = new File(pathFolderScan);
        List<File> collect = Stream.of(folder.listFiles()).filter(File::isDirectory).collect(Collectors.toList());
        for (File file : collect) {

        }
    }

    public static String buildFolderPath(String folderParent, String folderChild) {
        return folderParent + File.separatorChar + folderChild;
    }
}
