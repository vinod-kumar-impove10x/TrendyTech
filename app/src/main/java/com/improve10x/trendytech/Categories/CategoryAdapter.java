package com.improve10x.trendytech.Categories;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.improve10x.trendytech.Products.ProductsActivity;
import com.improve10x.trendytech.R;

import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryViewHolder> {
     OnItemActionListener onItemActionListener;

     public void setOnItemActionListener(OnItemActionListener listener) {
       onItemActionListener = listener;
     }
    public List<String> categoryList;

    void setData(List<String> categoryList) {
     this.categoryList = categoryList;
     notifyDataSetChanged();
    }
    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.categories_item,parent,false);
        CategoryViewHolder categoryViewHolder = new CategoryViewHolder(view);
        return categoryViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
        String string = categoryList.get(position);
        holder.titleTxt.setText(categoryList.get(position));
        holder.itemView.setOnClickListener(v -> {
            onItemActionListener.onItemClicked(string);
        });

    }

    @Override
    public int getItemCount() {
        return categoryList.size();
    }
}
