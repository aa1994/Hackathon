package com.example.adityaagarwal.hackathon;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class EventAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private EventResponse eventResponse;
    private EventViewModel viewModel;
    private EventView.Listener clickListener;


    public void setEventList(EventResponse eventResponse) {
        this.eventResponse = eventResponse;
    }

    public class SimpleViewHolder extends RecyclerView.ViewHolder {
        public SimpleViewHolder(View itemView) {
            super(itemView);
        }
    }

    public void setClickListener(EventView.Listener clickListener) {
        this.clickListener = clickListener;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        EventView eventView = (EventView) LayoutInflater.from(parent.getContext()).inflate(R.layout.event_view_layout, parent, false);
        return new SimpleViewHolder(eventView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        viewModel = new EventViewModel(eventResponse);
        EventView view = (EventView) holder.itemView;
        view.setClickListener(clickListener);
        view.bindTo(viewModel);
    }

    @Override
    public int getItemCount() {
        return 1;
    }


}
