package com.abc.shoptogethermyntra;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class signuppage extends AppCompatActivity {
    private TextView logintxtbtn;
    private EditText Name;
    private EditText Email;
    private EditText Phonenumber;
    private EditText Password;
    private Button btnSignUp;
    private FirebaseAuth mAuth;
    private DatabaseReference mDbRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signuppage);

        logintxtbtn = findViewById(R.id.logintxtbtn);
        logintxtbtn.setOnClickListener(v -> startActivity(new Intent(signuppage.this, loginpage.class)));

        Name = findViewById(R.id.Name);
        Email = findViewById(R.id.Email);
        Phonenumber = findViewById(R.id.Phonenumber);
        Password = findViewById(R.id.Password);
        btnSignUp = findViewById(R.id.btnSignup);
        mAuth = FirebaseAuth.getInstance();

        btnSignUp.setOnClickListener(v -> {
            String name = Name.getText().toString();
            String email = Email.getText().toString();
            String phoneNumber = Phonenumber.getText().toString();
            String password = Password.getText().toString();
            signUp(name, email, password,phoneNumber);
        });
    }

    private void signUp(String name, String email, String password, String s) {
        mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(this, task -> {
            if (task.isSuccessful()) {
                String uid = mAuth.getCurrentUser().getUid();
                addUserToDatabase(name, email, uid);
                Intent intent = new Intent(signuppage.this, MainActivity.class);
                startActivity(intent);
                finish();
            } else {
                // Sign up failed, log the error message
                Toast.makeText(signuppage.this, "Sign up failed:", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void addUserToDatabase(String name, String email, String uid) {
        mDbRef = FirebaseDatabase.getInstance().getReference();
        User user = new User(name, email, uid); // Assuming you have a User class
        mDbRef.child("users").child(uid).setValue(user);
    }

}
