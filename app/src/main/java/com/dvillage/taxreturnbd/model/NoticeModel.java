package com.dvillage.taxreturnbd.model;

public class NoticeModel {
    private String notice1;
    private String notice2;

    public NoticeModel() {
    }

    public NoticeModel(String notice1, String notice2) {
        this.notice1 = notice1;
        this.notice2 = notice2;
    }

    public String getNotice1() {
        return notice1;
    }

    public void setNotice1(String notice1) {
        this.notice1 = notice1;
    }

    public String getNotice2() {
        return notice2;
    }

    public void setNotice2(String notice2) {
        this.notice2 = notice2;
    }
}
