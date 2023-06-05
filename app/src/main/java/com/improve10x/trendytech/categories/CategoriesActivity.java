package com.improve10x.trendytech.categories;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.improve10x.trendytech.databinding.ActivityCategoriesBinding;
import com.improve10x.trendytech.network.CategoryApi;
import com.improve10x.trendytech.network.CategoryService;
import com.improve10x.trendytech.products.ProductsActivity;
import com.improve10x.trendytech.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CategoriesActivity extends AppCompatActivity {
    public ActivityCategoriesBinding activityCategoriesBinding;
    public CategoryService categoryService;
    public List<Category> categoryArrayList = new ArrayList<>();
    public CategoryAdapter categoryAdapter;
    public RecyclerView categoryRv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityCategoriesBinding = ActivityCategoriesBinding.inflate(getLayoutInflater());
        setContentView(activityCategoriesBinding.getRoot());
        getSupportActionBar().setTitle("Categories");
        //setupData();
        setupApiService();
        fetchCategories();
        setupAdapter();
        setupRecyclerView();
    }

    private void setupApiService() {
        CategoryApi categoryApi = new CategoryApi();
        categoryService = categoryApi.createCategoryService();
    }

    private void fetchCategories() {
        Call<List<Category>> call = categoryService.fetchCategories();
        call.enqueue(new Callback<List<Category>>() {
            @Override
            public void onResponse(Call<List<Category>> call, Response<List<Category>> response) {
                Toast.makeText(CategoriesActivity.this, "Successfully loaded the data", Toast.LENGTH_SHORT).show();
                List<Category> category = response.body();
                categoryAdapter.setData(category);
            }

            @Override
            public void onFailure(Call<List<Category>> call, Throwable t) {
                Toast.makeText(CategoriesActivity.this, "Failed to load the data", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void setupRecyclerView() {
        categoryRv = findViewById(R.id.categories_rv);
        categoryRv.setLayoutManager(new LinearLayoutManager(this));
        categoryRv.setAdapter(categoryAdapter);
    }

    private void setupAdapter() {
        categoryAdapter = new CategoryAdapter();
        categoryAdapter.setData(categoryArrayList);
        categoryAdapter.setOnItemActionListener(new OnItemActionListener() {
            @Override
            public void onItemClicked(int categoryId) {
                Intent intent = new Intent(CategoriesActivity.this, ProductsActivity.class);
                intent.putExtra("category", categoryId);
                startActivity(intent);

            }
        });
    }

   /* private void setupData() {
    categoryArrayList =new ArrayList<>();
    Category category = new Category();
    category.Title = "Electronics";
    categoryArrayList.add(category);


        Category category1 = new Category();
        category1.Title = "Jewellery";
        categoryArrayList.add(category1);


        Category category2 = new Category();
        category2.Title = "Men's Clothes";
        categoryArrayList.add(category2);


        Category category3 = new Category();
        category3.Title = "Women's Clothes";
        categoryArrayList.add(category3);


        Category category4 = new Category();
        category4.Title = "All";
        categoryArrayList.add(category4);
       }
    */

}