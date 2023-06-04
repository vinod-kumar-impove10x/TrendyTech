package com.improve10x.trendytech.categories;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.improve10x.trendytech.R;
import com.improve10x.trendytech.databinding.CategoriesItemBinding;

public class CategoryViewHolder extends RecyclerView.ViewHolder {

    CategoriesItemBinding categoriesItemBinding;

    public CategoryViewHolder(@NonNull CategoriesItemBinding categoriesItemBinding) {
        super(categoriesItemBinding.getRoot());
        this.categoriesItemBinding = categoriesItemBinding;


    }
}
