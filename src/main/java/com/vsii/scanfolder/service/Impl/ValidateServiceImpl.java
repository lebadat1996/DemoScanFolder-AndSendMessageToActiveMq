package com.vsii.scanfolder.service.Impl;

import com.vsii.scanfolder.service.AppServiceScan;
import com.vsii.scanfolder.service.ValidateService;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class ValidateServiceImpl implements ValidateService {

    @Override
    public boolean validateNameFolder(String folderName, String regex) {
        if (folderName.matches(regex)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean validateFile(File file, String extensions) {
        return true;
    }
}
