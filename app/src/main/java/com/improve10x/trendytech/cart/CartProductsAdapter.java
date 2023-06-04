package com.improve10x.trendytech.cart;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.improve10x.trendytech.R;
import com.improve10x.trendytech.models.Product;

import java.util.List;

public class CartProductsAdapter extends RecyclerView.Adapter<CartProductViewHolder> {

    public List<CartProductList> cartProducts;

    void setData(List<CartProductList> cartProductList){
        this.cartProducts = cartProductList;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public CartProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cart_item,parent,false);
        CartProductViewHolder cartProductViewHolder = new CartProductViewHolder(view);
        return cartProductViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CartProductViewHolder holder, int position) {
        CartProductList cartProduct = cartProducts.get(position);
        holder.productIdTxt.setText(String.valueOf(cartProduct.getProductId()));
        holder.quantityTxt.setText(String.valueOf(cartProduct.getQuantity()));
    }

    @Override
    public int getItemCount() {
        return cartProducts.size();
    }
}
