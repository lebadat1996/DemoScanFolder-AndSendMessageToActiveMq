package com.vsii.scanfolder.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Data
public class PropertyConfig {
    @Value(value = "com.vsii.folder.name")
    private String folderScan;

    @Value(value = "com.vsii.folder.name.children")
    private String folderChildren;
}
