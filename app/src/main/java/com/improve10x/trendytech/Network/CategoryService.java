package com.improve10x.trendytech.Network;

import com.improve10x.trendytech.Models.Product;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface CategoryService {
 @GET(Constants.PRODUCTSCATEGORIES_END_POINT)
 Call<List<String>> fetchCategories();

 @GET("/products/category/{categoryName}")
 Call<List<Product>> fetchProducts(@Path("categoryName") String categoryName);
}
