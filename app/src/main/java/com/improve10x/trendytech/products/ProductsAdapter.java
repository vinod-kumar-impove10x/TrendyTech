package com.improve10x.trendytech.products;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.improve10x.trendytech.models.Product;
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

    holder.priceTxt.setText(String.valueOf(product.getPrice()));

    Picasso.get().load(product.getImageUrl().get(0)).into(holder.image);
    holder.itemView.setOnClickListener(v -> {
        onItemActionListener.onClicked(productList.get(position).getId());
    });
   }

    @Override
    public int getItemCount() {
        return productList.size();
    }
}
