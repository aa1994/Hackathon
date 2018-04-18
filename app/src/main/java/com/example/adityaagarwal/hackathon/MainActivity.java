package com.example.adityaagarwal.hackathon;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.email)
    EditText email;

    @BindView(R.id.password)
    EditText password;

    @BindView(R.id.sign_in)
    TextView signIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        signIn.setOnClickListener(v -> {
            Intent intent = new Intent(this, AllCategoryActivity.class);
            getApplicationContext().startActivity(intent);
        });
    }
}
