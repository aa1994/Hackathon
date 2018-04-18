package com.example.adityaagarwal.hackathon;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AllCategoryActivity extends AppCompatActivity {

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    private AllCategoryAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.all_category_layout);

        ButterKnife.bind(this);

        adapter = new AllCategoryAdapter();

        recyclerView.setLayoutManager(new GridLayoutManager(getApplicationContext(), 2));
        recyclerView.setAdapter(adapter);

        List<String> list = new ArrayList<>();
        list.add("Food");
        list.add("Hiking");
        list.add("Rafting");
        list.add("Chill");
        list.add("Dance");
        list.add("Art");
        list.add("Museums");
        list.add("Movies");
        list.add("Architecture");


        adapter.setClickListener(clickListener);
        adapter.setCategoriesList(list);

    }

    CategoryView.Listener clickListener = viewModel -> Toast.makeText(getApplicationContext(), viewModel.getCategoryName(), Toast.LENGTH_SHORT).show();
}
