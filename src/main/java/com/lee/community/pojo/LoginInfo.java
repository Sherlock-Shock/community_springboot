package com.lee.community.pojo;

public class LoginInfo {
    private String userid;
    private String userrole;
    private String token;

    public LoginInfo() {
    }

    public LoginInfo(String userid, String userrole, String token) {
        this.userid = userid;
        this.userrole = userrole;
        this.token = token;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getUserrole() {
        return userrole;
    }

    public void setUserrole(String userrole) {
        this.userrole = userrole;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
