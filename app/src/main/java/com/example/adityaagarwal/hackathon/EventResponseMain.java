package com.example.adityaagarwal.hackathon;

import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class EventResponseMain {

    public static final String INSTANCE_ID = "REWARDS_PRODUCT_NULL";

    @PrimaryKey
    String id = INSTANCE_ID;

    @Expose
    @SerializedName("eventResponse")
    public List<EventResponse> eventResponse;

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public List<EventResponse> getEventResponse() {
        return eventResponse;
    }

    public void setEventResponse(List<EventResponse> eventResponse) {
        this.eventResponse = eventResponse;
    }
}


