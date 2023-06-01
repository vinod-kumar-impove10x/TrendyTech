package com.improve10x.trendytech.Products;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.improve10x.trendytech.Models.Product;
import com.improve10x.trendytech.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ProductsAdapter extends RecyclerView.Adapter<ProductViewHolder> {
    OnItemActionListener onItemActionListener;

    void setOnItemActionListener(OnItemActionListener onItemActionListener){
        this.onItemActionListener = onItemActionListener;
    }

    public List<Product> productList;

   void setData(List<Product> productList) {
     this.productList = productList;
     notifyDataSetChanged();

   }
    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.product_item, parent,false);
        ProductViewHolder productViewHolder = new ProductViewHolder(view);
        return productViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
    Product product = productList.get(position);
    holder.titleTxt.setText(product.getTitle());
    holder.rating.setRating(product.rating.getRate());
    holder.priceTxt.setText(String.valueOf(product.getPrice()));
    holder.countTxt.setText(String.valueOf(product.rating.getCount()));
    Picasso.get().load(product.getImageUrl()).into(holder.image);
    holder.itemView.setOnClickListener(v -> {
        onItemActionListener.onClicked(productList.get(position).getId());
    });
   }

    @Override
    public int getItemCount() {
        return productList.size();
    }
}
