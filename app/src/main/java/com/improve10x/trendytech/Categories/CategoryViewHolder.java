package com.improve10x.trendytech.Categories;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.improve10x.trendytech.R;

public class CategoryViewHolder extends RecyclerView.ViewHolder {

 TextView titleTxt;

    public CategoryViewHolder(@NonNull View itemView) {
        super(itemView);

        titleTxt = itemView.findViewById(R.id.title_txt);
    }
}
