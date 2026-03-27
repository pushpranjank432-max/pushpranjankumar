package com.milkmart.app;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.ArrayList;
import java.util.List;

public class DashboardActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ProductAdapter adapter;
    private List<ProductModel> productList;
    private List<ProductModel> filteredList;
    private EditText searchBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        // UI Connect karna
        searchBar = findViewById(R.id.searchBar);
        recyclerView = findViewById(R.id.recyclerView);
        FloatingActionButton btnAdd = findViewById(R.id.fabAddProduct);
        FloatingActionButton btnOrders = findViewById(R.id.btnAdminOrders);

        // Dummy Data (Real app mein ye database se aayega)
        productList = new ArrayList<>();
        productList.add(new ProductModel("Fresh Milk (1L)", "65", null));
        productList.add(new ProductModel("Pure Ghee (500g)", "450", null));
        productList.add(new ProductModel("Fresh Paneer", "80", null));

        filteredList = new ArrayList<>(productList);
        adapter = new ProductAdapter(filteredList);

        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        recyclerView.setAdapter(adapter);

        // SEARCH LOGIC
        searchBar.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                filterProducts(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });

        // ADMIN: ADD PRODUCT SCREEN PAR JANA
        btnAdd.setOnClickListener(v -> {
            startActivity(new Intent(this, AddProductActivity.class));
        });

        // ADMIN: VIEW ORDERS SCREEN PAR JANA
        btnOrders.setOnClickListener(v -> {
            startActivity(new Intent(this, AdminOrdersActivity.class));
        });
    }

    private void filterProducts(String text) {
        filteredList.clear();
        for (ProductModel item : productList) {
            if (item.getProductName().toLowerCase().contains(text.toLowerCase())) {
                filteredList.add(item);
            }
        }
        adapter.notifyDataSetChanged();
    }
}
