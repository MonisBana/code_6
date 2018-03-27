package com.mab.code_6;

/**
 * Created by MonisBana on 3/7/2018.
 */

public class Card {
    String cropName;
    int quantity;
    String sellarName,buyerName;
    int price;

    public Card() {
    }

    public Card(String cropName, int quantity, String sellarName, String buyerName, int price) {
        this.cropName = cropName;
        this.quantity = quantity;
        this.sellarName = sellarName;
        this.buyerName = buyerName;
        this.price = price;
    }

    public String getCropName() {
        return cropName;
    }

    public void setCropName(String cropName) {
        this.cropName = cropName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getSellarName() {
        return sellarName;
    }

    public void setSellarName(String sellarName) {
        this.sellarName = sellarName;
    }

    public String getBuyerName() {
        return buyerName;
    }

    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
