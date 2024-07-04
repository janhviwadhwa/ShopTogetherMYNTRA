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
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class wwdress extends AppCompatActivity {
    private Spinner spinnerSort;
    private ListView listView;
    private boolean[] isHeartFilled = new boolean[6];
    private boolean[] isStarFilled = new boolean[6];
    private int[] heartCounts = new int[6];
    private int[] starCounts = new int[6];
    private TextView[] heartCountViews = new TextView[6];
    private TextView[] starCountViews = new TextView[6];
    private DatabaseReference databaseReference;
    private ArrayList<Dress> dresses = new ArrayList<>();
    private DressAdapter dressAdapter;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wwdresses);

        // Initialize Firebase
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        databaseReference = database.getReference();

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

        heartCountViews[0] = findViewById(R.id.heart_count1);
        heartCountViews[1] = findViewById(R.id.heart_count2);
        heartCountViews[2] = findViewById(R.id.heart_count3);
        heartCountViews[3] = findViewById(R.id.heart_count4);
        heartCountViews[4] = findViewById(R.id.heart_count5);
        heartCountViews[5] = findViewById(R.id.heart_count6);

        starCountViews[0] = findViewById(R.id.star_count1);
        starCountViews[1] = findViewById(R.id.star_count2);
        starCountViews[2] = findViewById(R.id.star_count3);
        starCountViews[3] = findViewById(R.id.star_count4);
        starCountViews[4] = findViewById(R.id.star_count5);
        starCountViews[5] = findViewById(R.id.star_count6);

        setHeartClickListener(heartButton1, 0);
        setHeartClickListener(heartButton2, 1);
        setHeartClickListener(heartButton3, 2);
        setHeartClickListener(heartButton4, 3);
        setHeartClickListener(heartButton5, 4);
        setHeartClickListener(heartButton6, 5);
        setStarClickListener(starButton1, 0);
        setStarClickListener(starButton2, 1);
        setStarClickListener(starButton3, 2);
        setStarClickListener(starButton4, 3);
        setStarClickListener(starButton5, 4);
        setStarClickListener(starButton6, 5);

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

        // Initialize DressAdapter
        dressAdapter = new DressAdapter(this, dresses);
        listView.setAdapter(dressAdapter);

        // Listen for changes in the Firebase database and update the UI
        for (int i = 0; i < 6; i++) {
            int index = i;
            databaseReference.child("heartCounts").child(String.valueOf(index)).addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    Integer count = dataSnapshot.getValue(Integer.class);
                    if (count != null) {
                        heartCounts[index] = count;
                        heartCountViews[index].setText(String.valueOf(count));
                        updateDress(index, count, starCounts[index]);
                    }
                }

                @Override
                public void onCancelled(DatabaseError error) {
                    // Failed to read value
                }
            });

            databaseReference.child("starCounts").child(String.valueOf(index)).addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    Integer count = dataSnapshot.getValue(Integer.class);
                    if (count != null) {
                        starCounts[index] = count;
                        starCountViews[index].setText(String.valueOf(count));
                        updateDress(index, heartCounts[index], count);
                    }
                }

                @Override
                public void onCancelled(DatabaseError error) {
                    // Failed to read value
                }
            });

            // Fetch initial data and update the UI
            databaseReference.child("heartCounts").child(String.valueOf(index)).addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    Integer count = dataSnapshot.getValue(Integer.class);
                    if (count != null) {
                        heartCounts[index] = count;
                        heartCountViews[index].setText(String.valueOf(count));
                        updateDress(index, count, starCounts[index]);
                    }
                }

                @Override
                public void onCancelled(DatabaseError error) {
                    // Failed to read value
                }
            });

            databaseReference.child("starCounts").child(String.valueOf(index)).addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    Integer count = dataSnapshot.getValue(Integer.class);
                    if (count != null) {
                        starCounts[index] = count;
                        starCountViews[index].setText(String.valueOf(count));
                        updateDress(index, heartCounts[index], count);
                    }
                }

                @Override
                public void onCancelled(DatabaseError error) {
                    // Failed to read value
                }
            });
        }
    }

    private void setHeartClickListener(ImageButton heartButton, int index) {
        heartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isHeartFilled[index]) {
                    heartCounts[index]--;
                    heartButton.setImageResource(R.drawable.heartout);
                } else {
                    heartCounts[index]++;
                    heartButton.setImageResource(R.drawable.heartfill2);
                }
                isHeartFilled[index] = !isHeartFilled[index]; // Toggle the state
                databaseReference.child("heartCounts").child(String.valueOf(index)).setValue(heartCounts[index]);
            }
        });
    }

    private void setStarClickListener(ImageButton starButton, int index) {
        starButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isStarFilled[index]) {
                    starCounts[index]--;
                    starButton.setImageResource(R.drawable.star1);
                } else {
                    starCounts[index]++;
                    starButton.setImageResource(R.drawable.starfill2);
                }
                isStarFilled[index] = !isStarFilled[index]; // Toggle the state
                databaseReference.child("starCounts").child(String.valueOf(index)).setValue(starCounts[index]);
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
                int itemId = item.getItemId();
                if (itemId == R.id.sort_high_to_low) {
                    sortDressesByStars(false);
                    return true;
                } else if (itemId == R.id.sort_low_to_high) {
                    sortDressesByStars(true);
                    return true;
                } else {
                    return false;
                }
            }
        });

        popupMenu.show();
    }


    private void sortDressesByStars(boolean ascending) {
        Collections.sort(dresses, new Comparator<Dress>() {
            @Override
            public int compare(Dress d1, Dress d2) {
                return ascending ? Integer.compare(d1.getStarCount(), d2.getStarCount()) : Integer.compare(d2.getStarCount(), d1.getStarCount());
            }
        });
        dressAdapter.notifyDataSetChanged();
    }

    private void updateDress(int index, int heartCount, int starCount) {
        if (index < dresses.size()) {
            dresses.get(index).setHeartCount(heartCount);
            dresses.get(index).setStarCount(starCount);
        } else {
            dresses.add(new Dress(index, heartCount, starCount));
        }
        dressAdapter.notifyDataSetChanged();
    }
}
