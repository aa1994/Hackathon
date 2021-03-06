package com.example.adityaagarwal.hackathon;

import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import rx.Observable;
import io.reactivex.Single;

public interface EventService {
    @POST("event")
    io.reactivex.Observable<Response<EventResponseMain>> getEvents(@Body EventBody eventBody);

    @POST("rating")
    io.reactivex.Observable<Response<RatingResponse>> setRating(@Body RatingBody ratingBody);
}
