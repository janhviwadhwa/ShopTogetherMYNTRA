package com.abc.shoptogethermyntra;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Find buttons by ID
        Button womenWearButton = findViewById(R.id.button_womenwear);
        Button menWearButton = findViewById(R.id.button_menwear);

        // Set click listeners
        womenWearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Open WomenWear2Page
                Intent intent = new Intent(MainActivity.this, womenwear2page.class);
                startActivity(intent);
            }
        });

        menWearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Open MenWear2Page
                Intent intent = new Intent(MainActivity.this, menwear2page.class);
                startActivity(intent);
            }
        });
    }
}
