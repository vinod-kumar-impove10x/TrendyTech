package com.improve10x.trendytech.cart;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.improve10x.trendytech.R;

public class CartProductViewHolder extends RecyclerView.ViewHolder {

      TextView productIdTxt;
      TextView quantityTxt;
    public CartProductViewHolder(@NonNull View itemView) {
        super(itemView);

        productIdTxt = itemView.findViewById(R.id.product_id_txt);
        quantityTxt = itemView.findViewById(R.id.quantity_txt);
    }
}
