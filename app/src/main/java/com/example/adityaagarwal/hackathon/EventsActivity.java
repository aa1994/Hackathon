package com.example.adityaagarwal.hackathon;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RatingBar;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class EventsActivity extends AppCompatActivity {

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    OkHttpClient okHttpClient;
    EventService eventService;
    Retrofit retrofit;
    EventAdapter adapter;
    EventResponse eventResponse;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.event_activity_layout);

        ButterKnife.bind(this);

        adapter = new EventAdapter();

        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setAdapter(adapter);

        okHttpClient = new OkHttpClient();

        okHttpClient.newBuilder()
                .connectTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)
                .build();

        retrofit = new Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl("http://10.6.1.47:8005/")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        eventService = retrofit.create(EventService.class);

        eventResponse = new EventResponse();
        eventResponse.setDescription("Rohan");
        eventResponse.setAddress("WF");
        eventResponse.setStartDate("20/4/18");
        eventResponse.setEndDate("5/5/18");

        adapter.setEventList(eventResponse);

        adapter.setClickListener((eventView, viewModel) -> {
            Intent intent = new Intent(this , RatingActivity.class);
            startActivity(intent);
        });


//        eventService.getEvents()
//                .subscribeOn(io.reactivex.schedulers.Schedulers.io())
//                .observeOn(io.reactivex.android.schedulers.AndroidSchedulers.mainThread())
//                .subscribe(eventResponseResponse -> {
//                    if (eventResponseResponse == null) {
//                        Log.d("RESPONSE_EVENTS_ACT", " : NULL");
//                    } else {
//                        Log.d("RESPONSE_EVENTS_ACT", " : " + eventResponseResponse.body().address);
//                    }
//                });


    }
}
