package com.abc.shoptogethermyntra;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

public class mwshorts extends AppCompatActivity {
    private Spinner spinnerSort;
    private ListView listView;
    private boolean[] isHeartFilled = new boolean[6];
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mwshorts);

        spinnerSort = findViewById(R.id.spinner_sort);
        listView = findViewById(R.id.list_view);
        ImageButton heartButton1 = findViewById(R.id.heart_button1);
        ImageButton heartButton2 = findViewById(R.id.heart_button2);
        ImageButton heartButton3 = findViewById(R.id.heart_button3);
        ImageButton heartButton4 = findViewById(R.id.heart_button4);
        ImageButton heartButton5 = findViewById(R.id.heart_button5);
        ImageButton heartButton6 = findViewById(R.id.heart_button6);
        ImageButton starButton1 = findViewById(R.id.star_button1);
        ImageButton starButton2 = findViewById(R.id.star_button2);
        ImageButton starButton3 = findViewById(R.id.star_button3);
        ImageButton starButton4 = findViewById(R.id.star_button4);
        ImageButton starButton5 = findViewById(R.id.star_button5);
        ImageButton starButton6 = findViewById(R.id.star_button6);
        setHeartClickListener(heartButton1, 0);
        setHeartClickListener(heartButton2, 1);
        setHeartClickListener(heartButton3, 2);
        setHeartClickListener(heartButton4, 3);
        setHeartClickListener(heartButton5, 4);
        setHeartClickListener(heartButton6, 5);
        setstarClickListener(starButton1, 0);
        setstarClickListener(starButton2, 1);
        setstarClickListener(starButton3, 2);
        setstarClickListener(starButton4, 3);
        setstarClickListener(starButton5, 4);
        setstarClickListener(starButton6, 5);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.sorting_options, android.R.layout.simple_spinner_item);

        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Apply the adapter to the spinner
        spinnerSort.setAdapter(adapter);

        // Set spinner item click listener to show sorting options
        spinnerSort.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                showSortingOptions(view);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Handle no item selected
            }
        });
    }

    private void setHeartClickListener(ImageButton heartButton, int index) {
        heartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isHeartFilled[index]) {
                    heartButton.setImageResource(R.drawable.heartout);
                } else {
                    heartButton.setImageResource(R.drawable.heartfill2);
                }
                isHeartFilled[index] = !isHeartFilled[index]; // Toggle the state
            }
        });
    }
    private void setstarClickListener(ImageButton starButton, int index) {
        starButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isHeartFilled[index]) {
                    starButton.setImageResource(R.drawable.star1);
                } else {
                    starButton.setImageResource(R.drawable.starfill2);
                }
                isHeartFilled[index] = !isHeartFilled[index]; // Toggle the state
            }
        });
    }
    private void showSortingOptions(View view) {
        PopupMenu popupMenu = new PopupMenu(this, view);
        popupMenu.getMenuInflater().inflate(R.menu.sorting_options_menu, popupMenu.getMenu());

        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @SuppressLint("NonConstantResourceId")
            @Override
            public boolean onMenuItemClick(MenuItem item) {
//                switch (item.getItemId()) {
//                    case R.id.menu_high_to_low:
//                        // Handle high to low sorting
//                        // Example: Sort your data in high to low order
//                        return true;
//                    case R.id.menu_low_to_high:
//                        // Handle low to high sorting
//                        // Example: Sort your data in low to high order
//                        return true;
//                    default:
                return false;
//                }
            }
        });

        popupMenu.show();
    }
}
