package com.mab.code_6;

/**
 * Created by MonisBana on 3/7/2018.
 */

public class Buyer {
   private String id,name,lang,address,mobile;
   private int adhaarNo;

    public Buyer() {
    }

    public Buyer(String id, String name, String lang, String address, String mobile, int adhaarNo) {
        this.id = id;
        this.name = name;
        this.lang = lang;
        this.address = address;
        this.mobile = mobile;
        this.adhaarNo = adhaarNo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public int getAdhaarNo() {
        return adhaarNo;
    }

    public void setAdhaarNo(int adhaarNo) {
        this.adhaarNo = adhaarNo;
    }
}
