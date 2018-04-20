package com.example.adityaagarwal.hackathon;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RatingResponse {

    @Expose
    @SerializedName("status")
    public String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
