package com.doing.specification.entity;


import java.io.Serializable;

public class PrimaryKey implements Serializable {

    private String specid;

    private String username;

    public String getSpecid() {
        return specid;
    }

    public void setSpecid(String specid) {
        this.specid = specid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
