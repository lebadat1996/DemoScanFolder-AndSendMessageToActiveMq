package com.vsii.scanfolder.config;

import com.vsii.scanfolder.entity.Response;

public class Constant {
    public Constant() {
    }

    public static Response responseSuccess() {
        Response response = new Response();
        response.setMessage("Scan Success");
        response.setStatus("000");
        return response;
    }

    public static Response responseUnSuccess() {
        Response response = new Response();
        response.setMessage("Scan No Success");
        response.setStatus("001");
        return response;
    }
}
