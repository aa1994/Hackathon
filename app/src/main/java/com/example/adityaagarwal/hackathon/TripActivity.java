package com.example.adityaagarwal.hackathon;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TripActivity extends AppCompatActivity {

    @BindView(R.id.city_text)
    EditText cityText;

    @BindView(R.id.fromDate)
    EditText fromDate;

    @BindView(R.id.toDate)
    EditText toDate;

    @BindView(R.id.next)
    TextView next;

    Calendar myCalendar;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.trip_activity_layout);

        ButterKnife.bind(this);
        myCalendar = Calendar.getInstance();

        Bundle bundle = getIntent().getExtras();

        ArrayList<String> selectedCategory = new ArrayList<>();
        if (bundle != null) {
            selectedCategory = bundle.getStringArrayList("SELECTED_CATEGORY");
        }

        DatePickerDialog.OnDateSetListener date = (view, year, month, dayOfMonth) -> {
            month = month + 1;
            fromDate.setText(dayOfMonth + "/" + month + "/" + year);
        };

        fromDate.setOnClickListener(v -> {
            new DatePickerDialog(this, date, myCalendar.get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                    myCalendar.get(Calendar.DAY_OF_MONTH)).show();
        });

        DatePickerDialog.OnDateSetListener date1 = (view, year, month, dayOfMonth) -> {
            month = month + 1;
            toDate.setText(dayOfMonth + "/" + month + "/" + year);
        };

        toDate.setOnClickListener(v -> {
            new DatePickerDialog(this, date1, myCalendar.get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                    myCalendar.get(Calendar.DAY_OF_MONTH)).show();
        });

        next.setOnClickListener(v -> {
            Intent intent = new Intent(this, EventsActivity.class);
            intent.putExtra("CITY", cityText.getText().toString());
            intent.putExtra("START_DATE", fromDate.getText().toString());
            intent.putExtra("TO_DATE", toDate.getText().toString());
            startActivity(intent);
        });
    }
}
