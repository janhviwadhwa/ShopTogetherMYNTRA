package com.abc.shoptogethermyntra;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class menwear2page extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menwear2page);

        // Find buttons by ID
        Button polosButton = findViewById(R.id.polos);
        Button tshirtsButton = findViewById(R.id.tshirts);
        Button shortsButton = findViewById(R.id.mwshorts);
        Button jeansButton = findViewById(R.id.mwjeans);
        Button shirtsButton = findViewById(R.id.shirts);

        // Set click listener for the polos button
        polosButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Open MWPolo page
                Intent intent = new Intent(menwear2page.this, mwpolo.class);
                startActivity(intent);
            }
        });

        // Set click listener for the t-shirts button
        tshirtsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Open MWTShirt page
                Intent intent = new Intent(menwear2page.this, mwtshirt.class);
                startActivity(intent);
            }
        });

        // Set click listener for the shorts button
        shortsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Open MWShorts page
                Intent intent = new Intent(menwear2page.this, mwshorts.class);
                startActivity(intent);
            }
        });

        // Set click listener for the jeans button
        jeansButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Open MWJeans page
                Intent intent = new Intent(menwear2page.this, mwjeans.class);
                startActivity(intent);
            }
        });

        // Set click listener for the shirts button
        shirtsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Open MWShirt page
                Intent intent = new Intent(menwear2page.this, mwshirt.class);
                startActivity(intent);
            }
        });
    }
}
