package com.milkmart.app;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class DashboardActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ProductAdapter adapter;
    private List<ProductModel> productList;
    private Button btnViewCart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        // UI elements connect karna
        recyclerView = findViewById(R.id.recyclerView);
        btnViewCart = findViewById(R.id.btnViewCart); // Is ID ka button layout mein hona chahiye

        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));

        // Dummy Data
        productList = new ArrayList<>();
        productList.add(new ProductModel("Fresh Milk (1L)", "65.00", 0));
        productList.add(new ProductModel("Pure Ghee (500g)", "450.00", 0));
        productList.add(new ProductModel("Fresh Paneer", "80.00", 0));

        adapter = new ProductAdapter(productList);
        recyclerView.setAdapter(adapter);

        // Cart Screen par jaane ke liye logic
        btnViewCart.setOnClickListener(v -> {
            Intent intent = new Intent(DashboardActivity.this, CartActivity.class);
            startActivity(intent);
        });
    }
}
