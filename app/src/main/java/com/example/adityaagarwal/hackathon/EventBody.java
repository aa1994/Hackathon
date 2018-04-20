package com.example.adityaagarwal.hackathon;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class EventBody {

    @Expose
    @SerializedName("placename")
    public String placeName;

    @Expose
    @SerializedName("customerid")
    public String customerId;

    public String getCustomerId() {
        return customerId;
    }

    public String getPlaceName() {
        return placeName;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }
}
