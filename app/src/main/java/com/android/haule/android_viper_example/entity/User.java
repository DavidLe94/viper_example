package com.android.haule.android_viper_example.entity;

import java.io.Serializable;

/**
 * Created by Hau Le on 2018-10-08.
 */
public class User implements Serializable{
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
