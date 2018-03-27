package com.mab.mongodbcloud.Class;

import com.google.gson.annotations.SerializedName;

/**
 * Created by MonisBana on 3/1/2018.
 */

public class Id {
    @SerializedName("$oid")
    private String oid;

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }
}
