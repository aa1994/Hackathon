package com.example.adityaagarwal.hackathon;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

class AllCategoryAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<String> categoriesList = new ArrayList<>();
    private CategoriesViewModel viewModel;
    private CategoryView.Listener clickListener;

    public void setClickListener(CategoryView.Listener clickListener) {
        this.clickListener = clickListener;
    }

    public class SimpleViewHolder extends RecyclerView.ViewHolder {
        public SimpleViewHolder(View itemView) {
            super(itemView);
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CategoryView view = (CategoryView) LayoutInflater.from(parent.getContext()).inflate(R.layout.category_view, parent, false);
        return new SimpleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        viewModel = new CategoriesViewModel(categoriesList.get(position) , false);
        CategoryView view = (CategoryView) holder.itemView;
        view.setClickListener(clickListener);
        view.bindTo(viewModel);
    }

    @Override
    public int getItemCount() {
        return categoriesList.size();
    }

    public void setCategoriesList(List<String> categoriesList) {
        this.categoriesList = categoriesList;
        notifyDataSetChanged();
    }
}
