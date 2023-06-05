package com.improve10x.trendytech.network;

import com.improve10x.trendytech.cart.CartProduct;
import com.improve10x.trendytech.categories.Category;
import com.improve10x.trendytech.models.Product;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface CategoryService {
 @GET(Constants.PRODUCTSCATEGORIES_END_POINT)
 Call<List<Category>> fetchCategories();

 @GET("api/v1/products/")
 Call<List<Product>> fetchProducts(@Query("categoryId") String categoryId);

 @GET("api/v1/products/4")
 Call<Product> fetchProductDetails();

 @GET("carts/1?userId=1")
 Call<CartProduct> fetchCartProducts();

}

