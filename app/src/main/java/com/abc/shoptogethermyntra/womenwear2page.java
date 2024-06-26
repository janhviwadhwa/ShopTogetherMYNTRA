package com.abc.shoptogethermyntra;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class womenwear2page extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_womenwear2page);

        // Find buttons by ID
        Button dressButton = findViewById(R.id.dresses);
        Button topsButton = findViewById(R.id.tops);
        Button skirtsButton = findViewById(R.id.shorts);
        Button jeansButton = findViewById(R.id.jeans);
        Button sportswearButton = findViewById(R.id.sportswear);

        // Set click listener for the dress button
        dressButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Open WWdress page
                Intent intent = new Intent(womenwear2page.this, wwdress.class);
                startActivity(intent);
            }
        });

        // Set click listener for the tops button
        topsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Open WWtops page
                Intent intent = new Intent(womenwear2page.this, wwtops.class);
                startActivity(intent);
            }
        });

        // Set click listener for the skirts button
        skirtsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Open WWskirts page
                Intent intent = new Intent(womenwear2page.this, wwskirts.class);
                startActivity(intent);
            }
        });

        // Set click listener for the jeans button
        jeansButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Open WWjeans page
                Intent intent = new Intent(womenwear2page.this, wwjeans.class);
                startActivity(intent);
            }
        });

        // Set click listener for the sportswear button
        sportswearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Open WWsportswear page
                Intent intent = new Intent(womenwear2page.this, wwsportswear.class);
                startActivity(intent);
            }
        });
    }
}
