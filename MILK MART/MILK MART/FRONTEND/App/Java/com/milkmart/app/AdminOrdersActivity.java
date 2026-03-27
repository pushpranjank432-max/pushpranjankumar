package com.milkmart.app;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class AdminOrdersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_orders);

        ListView listView = findViewById(R.id.ordersListView);
        DatabaseHelper db = new DatabaseHelper(this);
        ArrayList<String> orderList = new ArrayList<>();

        // Database se saare orders nikalna
        Cursor cursor = db.getAllOrders();
        
        if (cursor != null && cursor.moveToFirst()) {
            do {
                // Database columns: 0:id, 1:name, 2:phone, 3:address, 4:items, 5:total
                String name = cursor.getString(1);
                String phone = cursor.getString(2);
                String address = cursor.getString(3);
                String items = cursor.getString(4);
                String total = cursor.getString(5);

                String details = "📦 Order Details:\n" +
                                 "Name: " + name + "\n" +
                                 "Phone: " + phone + "\n" +
                                 "Address: " + address + "\n" +
                                 "Items: " + items + "\n" +
                                 "Total Bill: ₹" + total;
                
                orderList.add(details);
            } while (cursor.moveToNext());
            cursor.close();
        } else {
            Toast.makeText(this, "Abhi tak koi order nahi aaya hai!", Toast.LENGTH_SHORT).show();
        }

        // List ko screen par dikhane ke liye adapter
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, 
            android.R.layout.simple_list_item_1, orderList);
        listView.setAdapter(adapter);
    }
}
