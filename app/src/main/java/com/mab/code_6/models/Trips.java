package com.mab.code_6.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by MonisBana on 3/23/2018.
 */
public  class Trips {

    @SerializedName("origin")
    @Expose
    private List<String> origin = null;
    @SerializedName("destination")
    @Expose
    private List<String> destination = null;

    public List<String> getOrigin() {
        return origin;
    }

    public void setOrigin(List<String> origin) {
        this.origin = origin;
    }

    public List<String> getDestination() {
        return destination;
    }

    public void setDestination(List<String> destination) {
        this.destination = destination;
    }

}
