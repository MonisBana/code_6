package com.mab.code_6.models;

/**
 * Created by MonisBana on 3/23/2018.
 */
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Truck {

    @SerializedName("message")
    @Expose
    private Boolean message;
    @SerializedName("activated")
    @Expose
    private Boolean activated;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("trip")
    @Expose
    private List<String> trip = null;
    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("comp_id")
    @Expose
    private String compId;
    @SerializedName("trucknum")
    @Expose
    private String trucknum;
    @SerializedName("password")
    @Expose
    private String password;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("currentLoc")
    @Expose
    private String currentLoc;

    public Boolean getMessage() {
        return message;
    }

    public void setMessage(Boolean message) {
        this.message = message;
    }

    public Boolean getActivated() {
        return activated;
    }

    public void setActivated(Boolean activated) {
        this.activated = activated;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<String> getTrip() {
        return trip;
    }

    public void setTrip(List<String> trip) {
        this.trip = trip;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCompId() {
        return compId;
    }

    public void setCompId(String compId) {
        this.compId = compId;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCurrentLoc() {
        return currentLoc;
    }

    public void setCurrentLoc(String currentLoc) {
        this.currentLoc = currentLoc;
    }

}

