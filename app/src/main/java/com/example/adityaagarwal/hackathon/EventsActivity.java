package com.example.adityaagarwal.hackathon;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
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
    EventBody eventBody;

    private String city;
    private String fromDate;
    private String toDate;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.event_activity_layout);

        ButterKnife.bind(this);

        Bundle bundle = getIntent().getExtras();

        if (bundle != null) {
            city = bundle.getString("CITY");
            fromDate = bundle.getString("START_DATE");
            toDate = bundle.getString("TO_DATE");
        }

        Log.d("DATA_FROM", " : " + city + " : " + fromDate + " : " + toDate);

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
            Intent intent = new Intent(this, RatingActivity.class);
            startActivity(intent);
        });


        eventBody = new EventBody();
        eventBody.setCustomerId("100001");
        eventBody.setPlaceName(city);

        eventService.getEvents(eventBody)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(eventResponseResponse -> {

                }, throwable -> {

                });


    }
}
