package com.improve10x.trendytech.network;

import com.improve10x.trendytech.cart.CartProduct;
import com.improve10x.trendytech.models.Product;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface CategoryService {
 @GET(Constants.PRODUCTSCATEGORIES_END_POINT)
 Call<List<String>> fetchCategories();

 @GET("/products/category/{categoryName}")
 Call<List<Product>> fetchProducts(@Path("categoryName") String categoryName);

 @GET("/products/{productsId}")
 Call<Product> fetchProductDetails(@Path("productsId")int productId);

 @GET("carts/1?userId=1")
 Call<CartProduct> fetchCartProducts();

}

