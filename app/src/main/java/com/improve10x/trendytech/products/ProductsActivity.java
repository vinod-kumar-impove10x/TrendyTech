package com.improve10x.trendytech.products;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.improve10x.trendytech.models.Product;
import com.improve10x.trendytech.network.CategoryApi;
import com.improve10x.trendytech.network.CategoryService;
import com.improve10x.trendytech.ProductDetailsActivity;
import com.improve10x.trendytech.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductsActivity extends AppCompatActivity {

   public ArrayList<Product> productArrayList = new ArrayList<>();
   public RecyclerView productRv;
   public ProductsAdapter productsAdapter;
   public CategoryService productService;
   String category;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products);
        if (getIntent().hasExtra("category")) {
            category = getIntent().getStringExtra("category");
            getSupportActionBar().setTitle(category);
        }
        getSupportActionBar().setTitle("Products");
        setupApiService();
        setupAdapter();
        setupProductsRv();
        fetchProducts();
    }

    private void fetchProducts() {
        Call<List<Product>> call = productService.fetchProducts(category);
        call.enqueue(new Callback<List<Product>>() {
            @Override
            public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {
                Toast.makeText(ProductsActivity.this, "Successfully loaded the data", Toast.LENGTH_SHORT).show();
                List<Product> productList = response.body();
                productsAdapter.setData(productList);
            }

            @Override
            public void onFailure(Call<List<Product>> call, Throwable t) {
                Toast.makeText(ProductsActivity.this, "Failed to load the data", Toast.LENGTH_SHORT).show();
            }
        });



    }

    private void setupProductsRv() {
     productRv = findViewById(R.id.products_rv);
     productRv.setLayoutManager(new GridLayoutManager(this,2));
     productRv.setAdapter(productsAdapter);
    }

    private void setupAdapter() {
     productsAdapter = new ProductsAdapter();
     productsAdapter.setData(productArrayList);
    productsAdapter.setOnItemActionListener(new OnItemActionListener() {
        @Override
        public void onClicked(int productsId) {
            Intent intent = new Intent(getApplicationContext(), ProductDetailsActivity.class);
            intent.putExtra("productsDetails", productsId);
            startActivity(intent);
        }
    });
    }

    private void setupApiService() {

        CategoryApi categoryApi = new CategoryApi();
        productService = categoryApi.createCategoryService();

    }
}