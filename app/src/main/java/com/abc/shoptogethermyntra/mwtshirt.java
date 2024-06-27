package com.abc.shoptogethermyntra;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

public class mwtshirt extends AppCompatActivity {
    private Spinner spinnerSort;
    private ListView listView;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mwtshirt);

        spinnerSort = findViewById(R.id.spinner_sort);
        listView = findViewById(R.id.list_view);

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
