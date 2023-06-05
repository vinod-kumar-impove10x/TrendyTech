package com.improve10x.trendytech;

import org.junit.Test;

import static org.junit.Assert.*;

import com.google.gson.Gson;
import com.improve10x.trendytech.cart.CartProduct;
import com.improve10x.trendytech.categories.Category;
import com.improve10x.trendytech.models.Product;
import com.improve10x.trendytech.network.CategoryApi;
import com.improve10x.trendytech.network.CategoryService;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);

    }

    @Test
    public void getCategories() throws IOException {
        CategoryService service = new CategoryApi().createCategoryService();
        Call<List<Category>> call = service.fetchCategories();
        List<Category> categories = call.execute().body();
        assertNotNull(categories);
        assertFalse(categories.isEmpty());
        System.out.println(new Gson().toJson(categories));
    }

    @Test
    public  void getProducts() throws IOException {
        CategoryService service = new CategoryApi().createCategoryService();
        Call<List<Product>> call = service.fetchProducts("1");
        List<Product> Products = call.execute().body();
        assertNotNull(Products);
        //assertFalse(Products.isEmpty());
        System.out.println(new Gson().toJson(Products));
    }

     @Test
    public void getCart() throws IOException {
        CategoryService categoryService =new CategoryApi().createCategoryService();
        Call<CartProduct> call =  categoryService.fetchCartProducts();
        CartProduct cartProducts = call.execute().body();
        assertNotNull(cartProducts);
        System.out.println(new Gson().toJson(cartProducts));
     }
}