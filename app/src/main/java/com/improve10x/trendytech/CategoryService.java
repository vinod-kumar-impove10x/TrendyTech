package com.improve10x.trendytech;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CategoryService {
 @GET(Constants.PRODUCTSCATEGORIES_END_POINT)
 Call<List<String>> fetchCategories();
}
