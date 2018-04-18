package com.example.adityaagarwal.hackathon;

public class CategoriesViewModel {
    private String category;

    public CategoriesViewModel(String categories) {
        this.category = categories;
    }

    public String getCategoryName() {
        return category;
    }
}
