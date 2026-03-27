package com.milkmart.app;

import android.content.Intent;
import android.media.MediaPlayer; // Sound ke liye
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class AddressActivity extends AppCompatActivity {

    private EditText etName, etPhone, etAddress;
    private Button btnConfirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address);

        etName = findViewById(R.id.etFullName);
        etPhone = findViewById(R.id.etPhone);
        etAddress = findViewById(R.id.etHouseNo);
        btnConfirm = findViewById(R.id.btnSaveAddress);

        btnConfirm.setOnClickListener(v -> {
            String name = etName.getText().toString();
            String phone = etPhone.getText().toString();
            String address = etAddress.getText().toString();

            if (name.isEmpty() || phone.isEmpty() || address.isEmpty()) {
                Toast.makeText(this, "Details bhariye", Toast.LENGTH_SHORT).show();
            } else {
                DatabaseHelper db = new DatabaseHelper(this);
                // Real app mein cart se items nikalenge, abhi ke liye test string
                String items = "Milk (1L), Ghee (500g)"; 
                String total = "515.00"; 

                boolean success = db.placeOrder(name, phone, address, items, total);
                
                if (success) {
                    // SOUND BAJANA
                    playNotificationSound();

                    Toast.makeText(this, "Order Confirmed!", Toast.LENGTH_SHORT).show();
                    
                    // Success screen par bhejna
                    startActivity(new Intent(this, OrderSuccessActivity.class));
                    finish();
                }
            }
        });
    }

    private void playNotificationSound() {
        // res/raw/order_sound.mp3 ko play karega
        MediaPlayer mp = MediaPlayer.create(this, R.raw.order_sound);
        mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                mediaPlayer.release(); // Sound khatam hone par memory khali karna
            }
        });
        mp.start();
    }
}
