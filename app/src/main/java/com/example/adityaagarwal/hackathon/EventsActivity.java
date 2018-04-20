package com.example.adityaagarwal.hackathon;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.Log;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.util.ArrayList;
import java.util.List;
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
    EventBody eventBody;
    List<EventResponse> eventResponseList = new ArrayList<>();

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

        getEventList();


        adapter.setClickListener((eventView, viewModel) -> {
            Intent intent = new Intent(this, RatingActivity.class);
            startActivity(intent);
        });


        eventBody = new EventBody();
        eventBody.setCustomerId("100001");
        eventBody.setPlaceName(city);

        ItemTouchHelper.SimpleCallback itemTouchHelper = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT) {
            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {

            }
        };


//        eventService.getEvents(eventBody)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(eventResponseMainResponse -> {
//                    eventResponseMainResponse.body().eventResponse.get(0);
//                    adapter.setEventList(eventResponseMainResponse.body().eventResponse);
//                }, throwable -> {
//
//                });


    }

    private void getEventList() {
        EventResponse eventResponse;

        eventResponse = new EventResponse();
        eventResponse.setDescription("Concert");
        eventResponse.setAddress("Bangalore");
        eventResponse.setRating("4");
        eventResponse.setStartDate("20/4/18");
        eventResponse.setEndDate("5/5/18");

        eventResponseList.add(eventResponse);

        EventResponse eventResponse1;

        eventResponse1 = new EventResponse();
        eventResponse1.setDescription("Hike");
        eventResponse1.setAddress("Bangalore");
        eventResponse1.setRating("4");
        eventResponse1.setStartDate("20/4/18");
        eventResponse1.setEndDate("5/5/18");

        eventResponseList.add(eventResponse1);

        EventResponse eventResponse2;

        eventResponse2 = new EventResponse();
        eventResponse2.setDescription("Food Festival");
        eventResponse2.setAddress("Bangalore");
        eventResponse2.setRating("2.5");
        eventResponse2.setStartDate("20/4/18");
        eventResponse2.setEndDate("5/5/18");
        eventResponseList.add(eventResponse2);

        EventResponse eventResponse3;

        eventResponse3 = new EventResponse();
        eventResponse3.setDescription("History Walk");
        eventResponse3.setAddress("Bangalore");
        eventResponse3.setRating("2");
        eventResponse3.setStartDate("20/4/18");
        eventResponse3.setEndDate("5/5/18");
        eventResponseList.add(eventResponse3);

        EventResponse eventResponse4;

        eventResponse4 = new EventResponse();
        eventResponse4.setDescription("Marathon");
        eventResponse4.setAddress("Bangalore");
        eventResponse4.setRating("1");
        eventResponse4.setStartDate("20/4/18");
        eventResponse4.setEndDate("5/5/18");

        eventResponseList.add(eventResponse4);

        EventResponse eventResponse5;

        eventResponse5 = new EventResponse();
        eventResponse5.setDescription("Tech Conference");
        eventResponse5.setAddress("Bangalore");
        eventResponse5.setRating("4");
        eventResponse5.setStartDate("20/4/18");
        eventResponse5.setEndDate("5/5/18");

        eventResponseList.add(eventResponse5);

        adapter.setEventList(eventResponseList);
    }
}
