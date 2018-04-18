package com.example.adityaagarwal.hackathon;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CategoryView extends LinearLayout {

    @BindView(R.id.category_name)
    TextView categoryName;

    CategoriesViewModel viewModel;
    Listener clickListener = Listener.NoOp;
    private Context context;

    public interface Listener {

        void onClick(CategoryView categoryView, CategoriesViewModel viewModel);

        Listener NoOp = (v, vm) -> {
        };
    }

    public CategoryView(Context context) {
        super(context);
    }

    public CategoryView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        ButterKnife.bind(this);
    }

    public void setClickListener(Listener clickListener) {
        this.clickListener = clickListener;
        categoryName.setOnClickListener(view -> {
            clickListener.onClick(this, viewModel);
        });
    }

    public void bindTo(CategoriesViewModel viewModel) {
        this.viewModel = viewModel;
        requestLayout();
        validateView();
    }

    private void validateView() {
        categoryName.setText(viewModel.getCategoryName());
        if (viewModel.getIsSelected()) {
            categoryName.setTextColor(ContextCompat.getColor(getContext(), R.color.colorAccent));
        } else {
            categoryName.setTextColor(ContextCompat.getColor(getContext(), R.color.black));
        }
    }
}
