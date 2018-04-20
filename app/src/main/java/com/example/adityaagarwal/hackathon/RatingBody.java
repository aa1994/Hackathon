package com.example.adityaagarwal.hackathon;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RatingBody {

    @Expose
    @SerializedName("placename")
    private String placeName;

    @Expose
    @SerializedName("customerid")
    private String customerid;

    @Expose
    @SerializedName("rating")
    private String rating;

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getCustomerid() {
        return customerid;
    }

    public void setCustomerid(String customerid) {
        this.customerid = customerid;
    }

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }
}
