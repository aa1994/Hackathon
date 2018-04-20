package com.example.adityaagarwal.hackathon;

import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.POST;
import rx.Observable;
import io.reactivex.Single;

public interface EventService {
    @POST("event")
    io.reactivex.Observable<Response<EventResponse>> getEvents();

    @POST("rating")
    io.reactivex.Observable<Response<EventResponse>> getRating();
}
