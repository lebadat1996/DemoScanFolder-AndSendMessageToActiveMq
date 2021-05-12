package com.vsii.scanfolder.app;

import com.vsii.scanfolder.config.Constant;
import com.vsii.scanfolder.service.Impl.AppServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/vsii")
public class AppController {
    @Autowired
    AppServiceImpl service;

    @PostMapping("/scanFolder")
    public ResponseEntity<?> scanFolder() {
        try {
            String queue = "";
            service.scanFolder(queue);
            return new ResponseEntity<>(Constant.responseSuccess(), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(Constant.responseUnSuccess(), HttpStatus.BAD_REQUEST);
        }
    }

}
