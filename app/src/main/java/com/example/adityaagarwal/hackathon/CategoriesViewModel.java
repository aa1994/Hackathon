package com.example.adityaagarwal.hackathon;

public class CategoriesViewModel {

    private String category;
    private boolean isSelected;

    public CategoriesViewModel(String categories, boolean isSelected) {
        this.category = categories;
        this.isSelected = false;
    }

    public String getCategoryName() {
        return category;
    }

    public void setIsSelected(boolean isSelected) {
        this.isSelected = isSelected;
    }

    public boolean getIsSelected() {
        return isSelected;
    }
}
