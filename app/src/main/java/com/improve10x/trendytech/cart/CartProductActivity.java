package com.improve10x.trendytech.cart;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.improve10x.trendytech.R;
import com.improve10x.trendytech.models.Product;
import com.improve10x.trendytech.network.CategoryApi;
import com.improve10x.trendytech.network.CategoryService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CartProductActivity extends AppCompatActivity {

    public ArrayList<CartProductList> cartProductsArrayList = new ArrayList<>();
    public RecyclerView cartRv;
    public CartProductsAdapter cartProductsAdapter;
    public CategoryService cartProductService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        getSupportActionBar().setTitle("Cart Products");
        setupApiService();
        fetchCartProducts();
        setupAdapter();
        setupCartProductsRv();
    }

    private void fetchCartProducts() {
        Call<CartProduct> call = cartProductService.fetchCartProducts();
        call.enqueue(new Callback<CartProduct>() {
            @Override
            public void onResponse(Call<CartProduct> call, Response<CartProduct> response) {
                Toast.makeText(CartProductActivity.this, "Successfully loaded the data", Toast.LENGTH_SHORT).show();
                CartProduct cartProduct = response.body();
                cartProductsAdapter.setData(cartProduct.cartProductLists);
            }

            @Override
            public void onFailure(Call<CartProduct> call, Throwable t) {
                Toast.makeText(CartProductActivity.this, "Failed to load the data", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void setupCartProductsRv() {
        cartRv = findViewById(R.id.cart_rv);
        cartRv.setLayoutManager(new LinearLayoutManager(this));
        cartRv.setAdapter(cartProductsAdapter);
    }

    private void setupAdapter() {
        cartProductsAdapter = new  CartProductsAdapter();
        cartProductsAdapter.setData(cartProductsArrayList);
    }

    private void setupApiService() {
        CategoryApi categoryApi = new CategoryApi();
        cartProductService = categoryApi.createCategoryService();
    }
}