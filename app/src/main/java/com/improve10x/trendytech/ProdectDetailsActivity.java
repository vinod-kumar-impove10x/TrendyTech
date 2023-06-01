package com.improve10x.trendytech;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.improve10x.trendytech.Models.Product;
import com.improve10x.trendytech.Network.CategoryApi;
import com.improve10x.trendytech.Network.CategoryService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProdectDetailsActivity extends AppCompatActivity {
    public int productId;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prodect_details);
        getSupportActionBar().setTitle("ProductDetails");
        if (getIntent().hasExtra("productsDetails")) {
            productId = getIntent().getIntExtra("productsDetails",productId);
            fetchProductDetails();
        }
    }

    private void fetchProductDetails() {
        CategoryApi api = new CategoryApi();
        CategoryService service = api.createCategoryService();
        Call<Product> call = service.fetchProductDetails(productId);
        call.enqueue(new Callback<Product>() {
            @Override
            public void onResponse(Call<Product> call, Response<Product> response) {
                Product product = response.body();

            }

            @Override
            public void onFailure(Call<Product> call, Throwable t) {

            }
        });
    }
}