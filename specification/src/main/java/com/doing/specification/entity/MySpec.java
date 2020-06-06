package com.doing.specification.entity;

import java.util.List;

public class MySpec {
    private String service;
    private List<String> specdoc;

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public List<String> getSpecdoc() {
        return specdoc;
    }

    public void setSpecdoc(List<String> specdoc) {
        this.specdoc = specdoc;
    }
}
