package com.milkmart.app;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.List;

public class CartActivity extends AppCompatActivity {

    private TextView txtTotal;
    private CartManager cartManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        txtTotal = findViewById(R.id.txtTotalAmount);
        cartManager = new CartManager(this);
        
        calculateTotal();
    }

    private void calculateTotal() {
        List<ProductModel> items = cartManager.getCartItems();
        double total = 0;
        for (ProductModel item : items) {
            // String price ko double mein badal kar add karna
            total += Double.parseDouble(item.getProductPrice());
        }
        txtTotal.setText("Total Amount: ₹" + total);
    }
}
