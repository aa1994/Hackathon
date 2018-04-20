package com.example.adityaagarwal.hackathon;

public class EventViewModel {

    private EventResponse eventResponse;

    public EventViewModel(EventResponse eventResponse) {
        this.eventResponse = eventResponse;
    }

    public String getEventName() {
        return eventResponse.description;
    }

    public String getAddress() {
        return eventResponse.address;
    }

    public String getRating() {
        return eventResponse.rating;
    }

    public String getStartDate() {
        return eventResponse.startDate;
    }

    public String getEndDate() {
        return eventResponse.endDate;
    }
}
