package com.example.adityaagarwal.hackathon;

import android.content.Context;
import android.support.annotation.Nullable;
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

    public interface Listener {

        void onClick(CategoriesViewModel viewModel);

        Listener NoOp = (vm) -> {
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
            clickListener.onClick(viewModel);
        });
    }

    public void bindTo(CategoriesViewModel viewModel) {
        this.viewModel = viewModel;
        requestLayout();
        validateView();
    }

    private void validateView() {
        categoryName.setText(viewModel.getCategoryName());
    }

}
