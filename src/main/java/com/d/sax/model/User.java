package com.d.sax.model;

/**
 * Copyright (C) 2017-2018 https://www.htouhui.com - A project by regex
 *
 * @author xh.d
 * @since 2018/3/29 18:10
 */
public class User {
    private long id;
    private String name;
    private String password;

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}
