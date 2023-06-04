package com.improve10x.trendytech.cart;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class CartProduct {

    private  Integer id;

    private  Integer userId;

    private  String data;

    @SerializedName("products")
    public   ArrayList<CartProductList> cartProductLists;



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
