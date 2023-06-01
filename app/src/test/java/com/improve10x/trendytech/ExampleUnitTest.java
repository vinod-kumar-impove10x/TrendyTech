package com.improve10x.trendytech;

import org.junit.Test;

import static org.junit.Assert.*;

import com.google.gson.Gson;
import com.improve10x.trendytech.Models.Product;
import com.improve10x.trendytech.Network.CategoryApi;
import com.improve10x.trendytech.Network.CategoryService;

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
        Call<List<String>> call = service.fetchCategories();
        List<String> categories = call.execute().body();
        assertNotNull(categories);
        assertFalse(categories.isEmpty());
        System.out.println(new Gson().toJson(categories));
    }

    @Test
    public  void getProducts() throws IOException {
     CategoryService service = new CategoryApi().createCategoryService();
        Call<List<Product>> call = service.fetchProducts("jewelery");
        List<Product> Products = call.execute().body();
        assertNotNull(Products);
        assertFalse(Products.isEmpty());
        System.out.println(new Gson().toJson(Products));
    }
}