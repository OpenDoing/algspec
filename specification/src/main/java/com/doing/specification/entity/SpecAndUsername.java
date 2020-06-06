package com.doing.specification.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "spec")
@IdClass(PrimaryKey.class)
public class SpecAndUsername implements Serializable {

    @Id
    @Column(name = "SpecID", nullable = false)
    private String specid;
    @Id
    @Column(name = "username", nullable = false)
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
