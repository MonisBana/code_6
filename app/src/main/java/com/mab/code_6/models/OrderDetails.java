package com.mab.code_6.models;

/**
 * Created by MonisBana on 3/23/2018.
 */
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class OrderDetails {

    @SerializedName("farmer_id")
    @Expose
    private String farmerId;
    @SerializedName("transport_id")
    @Expose
    private String transportId;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("origin")
    @Expose
    private String origin;
    @SerializedName("destination")
    @Expose
    private String destination;
    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("merchant_id")
    @Expose
    private String merchantId;
    @SerializedName("crop_details")
    @Expose
    private CropDetails cropDetails;
    @SerializedName("farmer_amount")
    @Expose
    private Integer farmerAmount;
    @SerializedName("transport_amount")
    @Expose
    private Double transportAmount;
    @SerializedName("merchant_otp")
    @Expose
    private String merchantOtp;
    @SerializedName("farmer_otp")
    @Expose
    private String farmerOtp;
    @SerializedName("__v")
    @Expose
    private Integer v;

    public OrderDetails() {
    }

    public OrderDetails(String farmerId, String transportId, String status, String origin, String destination, String id, String merchantId, CropDetails cropDetails, Integer farmerAmount, Double transportAmount, String merchantOtp, String farmerOtp, Integer v) {
        this.farmerId = farmerId;
        this.transportId = transportId;
        this.status = status;
        this.origin = origin;
        this.destination = destination;
        this.id = id;
        this.merchantId = merchantId;
        this.cropDetails = cropDetails;
        this.farmerAmount = farmerAmount;
        this.transportAmount = transportAmount;
        this.merchantOtp = merchantOtp;
        this.farmerOtp = farmerOtp;
        this.v = v;
    }

    public String getFarmerId() {
        return farmerId;
    }

    public void setFarmerId(String farmerId) {
        this.farmerId = farmerId;
    }

    public String getTransportId() {
        return transportId;
    }

    public void setTransportId(String transportId) {
        this.transportId = transportId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    public CropDetails getCropDetails() {
        return cropDetails;
    }

    public void setCropDetails(CropDetails cropDetails) {
        this.cropDetails = cropDetails;
    }

    public Integer getFarmerAmount() {
        return farmerAmount;
    }

    public void setFarmerAmount(Integer farmerAmount) {
        this.farmerAmount = farmerAmount;
    }

    public Double getTransportAmount() {
        return transportAmount;
    }

    public void setTransportAmount(Double transportAmount) {
        this.transportAmount = transportAmount;
    }

    public String getMerchantOtp() {
        return merchantOtp;
    }

    public void setMerchantOtp(String merchantOtp) {
        this.merchantOtp = merchantOtp;
    }

    public String getFarmerOtp() {
        return farmerOtp;
    }

    public void setFarmerOtp(String farmerOtp) {
        this.farmerOtp = farmerOtp;
    }

    public Integer getV() {
        return v;
    }

    public void setV(Integer v) {
        this.v = v;
    }

}