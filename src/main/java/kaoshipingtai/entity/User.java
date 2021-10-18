package kaoshipingtai.entity;

public class User {

    private int Userid=0;
    private String Username=null;
    private String password=null;

    public int getUserid() {
        return this.Userid;
    }

    public void setUserid(int userid) {
        this.Userid = userid;
    }

    public String getUsername() {
        return this.Username;
    }

    public void setUsername(String username) {
        this.Username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
