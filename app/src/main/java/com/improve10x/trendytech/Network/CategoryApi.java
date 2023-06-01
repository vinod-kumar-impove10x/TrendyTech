package com.improve10x.trendytech.Network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CategoryApi {

   public CategoryService createCategoryService(){
       Retrofit retrofit = new Retrofit.Builder()
               .baseUrl(Constants.BASE_URL)
               .addConverterFactory(GsonConverterFactory.create())
               .build();
       CategoryService categoryService = retrofit.create(CategoryService.class);
       return categoryService;
   }
}
