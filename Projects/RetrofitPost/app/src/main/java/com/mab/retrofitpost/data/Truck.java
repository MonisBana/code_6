package com.mab.retrofitpost.data;

/**
 * Created by MonisBana on 3/20/2018.
 */
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Truck {

    @SerializedName("trucknum")
    @Expose
    private String trucknum;
    @SerializedName("password")
    @Expose
    private String password;
    @SerializedName("message")
    @Expose
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Truck() {
    }

    public Truck(String trucknum, String password) {
        this.trucknum = trucknum;
        this.password = password;
    }

    public String getTrucknum() {
        return trucknum;
    }

    public void setTrucknum(String trucknum) {
        this.trucknum = trucknum;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Truck{" +
                "trucknum='" + trucknum + '\'' +
                ", password='" + password +
                '}';
    }
}