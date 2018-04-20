package com.example.adityaagarwal.hackathon;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class EventView extends LinearLayout {

    Listener clickListener = Listener.NoOp;


    public interface Listener {

        void onClick(EventView eventView, EventViewModel viewModel);

        Listener NoOp = (v, vm) -> {
        };
    }

    @BindView(R.id.event_layout)
    LinearLayout eventLayout;

    @BindView(R.id.event_name)
    TextView eventName;

    @BindView(R.id.safety_score)
    TextView safetyScore;

    @BindView(R.id.start_date)
    TextView startDate;

    @BindView(R.id.end_date)
    TextView endDate;

    @BindView(R.id.address)
    TextView address;


    private EventViewModel viewModel;

    public EventView(Context context) {
        super(context);
    }

    public EventView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        ButterKnife.bind(this);
    }

    public void setClickListener(Listener clickListener) {
        this.clickListener = clickListener;
        eventLayout.setOnClickListener(view -> clickListener.onClick(this, viewModel));
    }

    public void bindTo(EventViewModel viewModel) {
        this.viewModel = viewModel;
        validateView();
    }

    private void validateView() {
        eventName.setText(viewModel.getEventName());
        safetyScore.setText("Safety Score : " + viewModel.getRating());
        startDate.setText(viewModel.getStartDate());
        endDate.setText(viewModel.getEndDate());
        address.setText(viewModel.getAddress());
    }
}
