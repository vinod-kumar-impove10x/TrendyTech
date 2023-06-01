package com.improve10x.trendytech.Categories;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.improve10x.trendytech.Network.CategoryApi;
import com.improve10x.trendytech.Network.CategoryService;
import com.improve10x.trendytech.Products.ProductsActivity;
import com.improve10x.trendytech.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CategoriesActivity extends AppCompatActivity {
public CategoryService categoryService;
public ArrayList<String> categoryArrayList = new ArrayList<>();
public CategoryAdapter categoryAdapter;
public RecyclerView categoryRv;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);
        getSupportActionBar().setTitle("Categories");
        //setupData();
        setupApiService();
        setupAdapter();
        setupRecyclerView();
        fetchCategories();

    }

    private void setupApiService() {
        CategoryApi categoryApi = new CategoryApi();
        categoryService = categoryApi.createCategoryService();
    }

    private void fetchCategories() {
        Call<List<String>> call = categoryService.fetchCategories();
        call.enqueue(new Callback<List<String>>() {
            @Override
            public void onResponse(Call<List<String>> call, Response<List<String>> response) {
                Toast.makeText(CategoriesActivity.this, "Successfully loaded the data", Toast.LENGTH_SHORT).show();
                List<String> category = response.body();
                categoryAdapter.setData(category);
            }

            @Override
            public void onFailure(Call<List<String>> call, Throwable t) {
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
        public void onItemClicked(String categoryName) {

            Intent intent = new Intent(getApplicationContext(), ProductsActivity.class);
            intent.putExtra("category", categoryName);
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