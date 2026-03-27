package com.milkmart.app;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class CartActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private CartManager cartManager;
    private TextView txtTotal;
    private Button btnCheckout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        recyclerView = findViewById(R.id.cartRecyclerView);
        txtTotal = findViewById(R.id.txtTotalAmount);
        btnCheckout = findViewById(R.id.btnPlaceOrder);
        
        cartManager = new CartManager(this);
        List<ProductModel> cartItems = cartManager.getCartItems();
        
        // Agar cart khali hai
        if (cartItems.isEmpty()) {
            Toast.makeText(this, "Aapka cart khali hai!", Toast.LENGTH_SHORT).show();
        }

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        ProductAdapter adapter = new ProductAdapter(cartItems); 
        recyclerView.setAdapter(adapter);

        // Total calculate karna
        double total = 0;
        for (ProductModel item : cartItems) {
            total += Double.parseDouble(item.getProductPrice());
        }
        txtTotal.setText("Total: ₹" + total);

        // ORDER KARNE KA LOGIC
        btnCheckout.setOnClickListener(v -> {
            if (cartItems.isEmpty()) {
                Toast.makeText(this, "Order karne ke liye pehle item add karein", Toast.LENGTH_SHORT).show();
            } else {
                // Order hone ke baad address screen par bhejna
                Intent intent = new Intent(CartActivity.this, AddressActivity.class);
                startActivity(intent);
                
                // Note: Real app mein yahan hum data server par bhejte hain
            }
        });
    }
}
