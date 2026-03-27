package com.milkmart.app;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class AddProductActivity extends AppCompatActivity {

    private ImageView imgPreview;
    private EditText etName, etPrice;
    private Uri imageUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_product);

        imgPreview = findViewById(R.id.imgSelect);
        etName = findViewById(R.id.etNewName);
        etPrice = findViewById(R.id.etNewPrice);
        Button btnUpload = findViewById(R.id.btnSaveProduct);

        // Gallery se photo choose karne ke liye
        imgPreview.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
            intent.addCategory(Intent.CATEGORY_OPENABLE);
            intent.setType("image/*");
            startActivityForResult(intent, 101);
        });

        btnUpload.setOnClickListener(v -> {
            if (imageUri != null && !etName.getText().toString().isEmpty()) {
                // Yahan product save karne ka logic aayega
                Toast.makeText(this, "Product Uploaded Successfully!", Toast.LENGTH_SHORT).show();
                finish();
            } else {
                Toast.makeText(this, "Please select image and enter name", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 101 && resultCode == RESULT_OK && data != null) {
            imageUri = data.getData();
            // Permission grant karna zaroori hai naye Android versions ke liye
            getContentResolver().takePersistableUriPermission(imageUri, Intent.FLAG_GRANT_READ_URI_PERMISSION);
            imgPreview.setImageURI(imageUri);
        }
    }
}
