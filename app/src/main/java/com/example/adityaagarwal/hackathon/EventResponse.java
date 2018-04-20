package com.example.adityaagarwal.hackathon;

import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class EventResponse {

    public static final String INSTANCE_ID = "REWARDS_PRODUCT_NULL";

    @PrimaryKey
    String id = INSTANCE_ID;

    @Expose
    @SerializedName("description")
    public String description;

    @Expose
    @SerializedName("endDateTime")
    public String endDate;

    @Expose
    @SerializedName("startDateTime")
    public String startDate;

    @Expose
    @SerializedName("address")
    public String address;

    public String getAddress() {
        return address;
    }

    public String getDescription() {
        return description;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
}
