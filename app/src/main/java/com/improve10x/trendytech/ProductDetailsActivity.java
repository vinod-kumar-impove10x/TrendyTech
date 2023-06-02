package com.improve10x.trendytech;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.improve10x.trendytech.Models.Product;
import com.improve10x.trendytech.Network.CategoryApi;
import com.improve10x.trendytech.Network.CategoryService;
import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductDetailsActivity extends AppCompatActivity {
    public int productId;
    public ImageView productDetailImg;
    public TextView titleTxt;
    public TextView description;
    public TextView price;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prodect_details);
        getSupportActionBar().setTitle("ProductDetails");
        if (getIntent().hasExtra("productsDetails")) {
            productId = getIntent().getIntExtra("productsDetails",productId);
            fetchProductDetails();
        }
    }

    private void fetchProductDetails() {
        CategoryApi api = new CategoryApi();
        CategoryService service = api.createCategoryService();
        Call<Product> call = service.fetchProductDetails(productId);
        call.enqueue(new Callback<Product>() {
            @Override
            public void onResponse(Call<Product> call, Response<Product> response) {
                Product product = response.body();
                productDetailImg = findViewById(R.id.product_Detail_img);
                Picasso.get().load(product.getImageUrl()).into(productDetailImg);
                titleTxt = findViewById(R.id.title_txt);
                titleTxt.setText(product.getTitle());
                price = findViewById(R.id.pd_price_txt);
                price.setText(String.valueOf(product.getPrice()));
                description = findViewById(R.id.pd_description_txt);
                description.setText(product.getDescription());

            }

            @Override
            public void onFailure(Call<Product> call, Throwable t) {

            }
        });
    }
}