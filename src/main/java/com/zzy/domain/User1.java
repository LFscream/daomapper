package com.zzy.domain;

import java.util.Date;

public class User1 {
private Integer userid;
private String username;
private Date userbirthday;
private String usersex;
private String useraddress;

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getUserbirthday() {
        return userbirthday;
    }

    public void setUserbirthday(Date userbirthday) {
        this.userbirthday = userbirthday;
    }

    public String getUsersex() {
        return usersex;
    }

    public void setUsersex(String usersex) {
        this.usersex = usersex;
    }

    public String getUseraddress() {
        return useraddress;
    }

    public void setUseraddress(String useraddress) {
        this.useraddress = useraddress;
    }

    @Override
    public String toString() {
        return "User1{" +
                "userid=" + userid +
                ", username='" + username + '\'' +
                ", userbirthday=" + userbirthday +
                ", usersex='" + usersex + '\'' +
                ", useraddress='" + useraddress + '\'' +
                '}';
    }
}
