package com.milkmart.app;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.util.ArrayList;
import java.util.List;

public class CartManager {
    private static final String PREF_NAME = "MilkMartCart";
    private static final String CART_KEY = "cart_items";
    private SharedPreferences sharedPreferences;
    private Gson gson;

    public CartManager(Context context) {
        sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        gson = new Gson();
    }

    // Item ko cart mein save karne ke liye
    public void addToCart(ProductModel product) {
        List<ProductModel> cartList = getCartItems();
        cartList.add(product);
        String json = gson.toJson(cartList);
        sharedPreferences.edit().putString(CART_KEY, json).apply();
    }

    // Sare items wapas pane ke liye
    public List<ProductModel> getCartItems() {
        String json = sharedPreferences.getString(CART_KEY, null);
        if (json == null) return new ArrayList<>();
        return gson.fromJson(json, new TypeToken<List<ProductModel>>(){}.getType());
    }
}
