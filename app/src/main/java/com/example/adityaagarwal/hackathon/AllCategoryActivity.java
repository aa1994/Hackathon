package com.example.adityaagarwal.hackathon;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AllCategoryActivity extends AppCompatActivity {

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    @BindView(R.id.done)
    TextView done;

    private AllCategoryAdapter adapter;
    List<String> categoryList = new ArrayList<>();
    List<String> selectedCategory = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.all_category_layout);

        ButterKnife.bind(this);

        adapter = new AllCategoryAdapter();

        recyclerView.setLayoutManager(new GridLayoutManager(getApplicationContext(), 2));
        recyclerView.setAdapter(adapter);


        createCategoryList();


        adapter.setClickListener(clickListener);
        adapter.setCategoriesList(categoryList);

        done.setOnClickListener(v -> {
            Intent intent = new Intent(this, EventsActivity.class);
            startActivity(intent);
        });

    }

    private void createCategoryList() {
        categoryList.add("Food");
        categoryList.add("Hiking");
        categoryList.add("Rafting");
        categoryList.add("Chill");
        categoryList.add("Dance");
        categoryList.add("Art");
        categoryList.add("Museums");
        categoryList.add("Movies");
        categoryList.add("Architecture");
        categoryList.add("Bars");
    }

    CategoryView.Listener clickListener = (categoryView, viewModel) -> {
        viewModel.setIsSelected(!viewModel.getIsSelected());
        if (viewModel.getIsSelected()) {
            selectedCategory.add(viewModel.getCategoryName());
        } else {
            selectedCategory.remove(viewModel.getCategoryName());
        }
        categoryView.bindTo(viewModel);
    };
}
