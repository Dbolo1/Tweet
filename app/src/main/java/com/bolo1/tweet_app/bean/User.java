package com.bolo1.tweet_app.bean;

import java.io.Serializable;

/**
 * Created by 菠萝 on 2018/6/25.
 */

public class User implements Serializable {


    private String user_id;
    private String user_name;
    private String user_pass;
    private String user_icon;
    private String data_type;

    public String getData_type() {
        return data_type;
    }

    public void setData_type(String data_type) {
        this.data_type = data_type;
    }

    @Override

    public String toString() {
//        return "{" +
//                "\"user_id\":\"" + user_id + "\"" +
//                ",\"user_name\":\"" + user_name + "\"" +
//                ",\"user_pass\":\"" + user_pass + "\"" +
//                ",\"user_icon\":\"" + user_icon + "\"" +
//               " }";
        return
                "{\"user_id\":\"" + user_id + "\"" +
                        ",\"user_name\":\"" + user_name + "\"" +
                        ",\"user_pass\":\"" + user_pass + "\"" +
                        ",\"user_icon\":\"" + user_icon + "\"" +
                        ",\"data_type\":\"" + data_type + "\"" +
                        "}";
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_pass() {
        return user_pass;
    }

    public void setUser_pass(String user_pass) {
        this.user_pass = user_pass;
    }

    public String getUser_icon() {
        return user_icon;
    }

    public void setUser_icon(String user_icon) {
        this.user_icon = user_icon;
    }
}
