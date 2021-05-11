package com.vsii.scanfolder.service;

import java.io.File;

public interface ValidateService {
    boolean validateNameFolder(String folderName, String regex);

    boolean validateFile(File file, String extensions);
}
