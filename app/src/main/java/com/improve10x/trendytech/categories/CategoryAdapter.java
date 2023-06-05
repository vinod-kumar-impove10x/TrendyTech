package com.improve10x.trendytech.categories;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.improve10x.trendytech.R;
import com.improve10x.trendytech.databinding.CategoriesItemBinding;

import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryViewHolder> {
     OnItemActionListener onItemActionListener;

     public void setOnItemActionListener(OnItemActionListener listener) {
       onItemActionListener = listener;
     }
    public List<Category> categoryList;

    void setData(List<Category> categoryList) {
     this.categoryList = categoryList;
     notifyDataSetChanged();
    }
    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CategoriesItemBinding categoriesItemBinding = CategoriesItemBinding.inflate(LayoutInflater.from(parent.getContext()),parent, false);
        CategoryViewHolder categoryViewHolder = new CategoryViewHolder(categoriesItemBinding);
        return categoryViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
        Category category= categoryList.get(position);
        holder.categoriesItemBinding.setCategory(category);// this is data binding.
        //holder.categoriesItemBinding.titleTxt.setText(category.getName()); This is view binding.
        holder.categoriesItemBinding.getRoot().setOnClickListener(v -> {
            onItemActionListener.onItemClicked(category.getId());
        });

    }

    @Override
    public int getItemCount() {
        return categoryList.size();
    }
}
