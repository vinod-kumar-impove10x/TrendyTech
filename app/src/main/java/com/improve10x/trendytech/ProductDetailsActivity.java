package com.improve10x.trendytech;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.improve10x.trendytech.cart.CartProductActivity;
import com.improve10x.trendytech.models.Product;
import com.improve10x.trendytech.network.CategoryApi;
import com.improve10x.trendytech.network.CategoryService;
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
        Call<Product> call = service.fetchProductDetails();
        call.enqueue(new Callback<Product>() {
            @Override
            public void onResponse(Call<Product> call, Response<Product> response) {
                Product product = response.body();
                productDetailImg = findViewById(R.id.product_Detail_img);
                Picasso.get().load(product.getImageUrl().get(0)).into(productDetailImg);
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.product_details_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.product_details_cart) {
            Intent intent = new Intent(this, CartProductActivity.class);
            startActivity(intent);
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }
}