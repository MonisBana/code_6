package com.mab.code_6.models;

/**
 * Created by MonisBana on 3/23/2018.
 */
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.mab.code_6.models.Response;

public class Truck {

    @SerializedName("message")
    @Expose
    private Boolean message;
    @SerializedName("response")
    @Expose
    private Response response;
    public Truck(Boolean message, Response response) {
        this.message = message;
        this.response = response;
    }

    public Truck(boolean message, Response respons) {
    }

    public Boolean getMessage() {
        return message;
    }

    public void setMessage(Boolean message) {
        this.message = message;
    }

    public Response getResponse() {
        return response;
    }

    public void setResponse(Response response) {
        this.response = response;
    }

            }

