package com.example.adityaagarwal.hackathon;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.RatingBar;
import android.widget.TextView;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RatingActivity extends AppCompatActivity {

    @BindView(R.id.safety_score_rating)
    RatingBar ratingBar;

    @BindView(R.id.submit)
    TextView submit;

    @BindView(R.id.back)
            TextView back;

    OkHttpClient okHttpClient;
    Retrofit retrofit;
    EventService eventService;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.safety_score_dialog_layout);

        ButterKnife.bind(this);

        submit.setOnClickListener(v -> {
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

            eventService.getRating();

        });

        back.setOnClickListener(v -> {
            this.finish();
        });

    }
}
