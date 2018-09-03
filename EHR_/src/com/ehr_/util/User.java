package com.ehr_.util;

public class User {

    private String username;
    private String userpass;
    private String sex;
    private String regtime;
    private String phone;


    public String getSex() {
        return sex;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getUserpass() {
        return userpass;
    }
    public void setUserpass(String userpass) {
        this.userpass = userpass;
    }
    public String getRegtime() {
        return regtime;
    }
    public void setRegtime(String regtime) {
        this.regtime = regtime;
    }


}
