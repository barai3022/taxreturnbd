package com.dvillage.taxreturnbd.model;

public class UserModel {
    private String tin;
    private String email;
    private String uid;
    private long timestamp;

    public UserModel() {
    }

    public UserModel(String tin, String email, String uid, long timestamp) {
        this.tin = tin;
        this.email = email;
        this.uid = uid;
        this.timestamp = timestamp;
    }

    public String getTin() {
        return tin;
    }

    public void setTin(String tin) {
        this.tin = tin;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
}
