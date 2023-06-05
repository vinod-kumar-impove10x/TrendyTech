package com.improve10x.trendytech.products;

import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.improve10x.trendytech.R;

public class ProductViewHolder extends RecyclerView.ViewHolder {

    ImageView image;
    TextView titleTxt;
    //RatingBar rating;
    TextView priceTxt;
    //TextView countTxt;


    public ProductViewHolder(@NonNull View itemView) {
        super(itemView);

       image = itemView.findViewById(R.id.product_img);
       titleTxt = itemView.findViewById(R.id.product_title_txt);
       //rating = itemView.findViewById(R.id.product_rating);
       priceTxt = itemView.findViewById(R.id.product_price_txt);
       //countTxt = itemView.findViewById(R.id.product_count_txt);


    }
}
