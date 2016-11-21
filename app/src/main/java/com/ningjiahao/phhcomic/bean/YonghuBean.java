package com.ningjiahao.phhcomic.bean;

import android.widget.EditText;

import cn.bmob.v3.BmobObject;

/**
 * Created by HP on 2016/11/21.
 */

public class YonghuBean extends BmobObject {

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

    public void setPassword(String pasword) {
        this.password = pasword;
    }
}
