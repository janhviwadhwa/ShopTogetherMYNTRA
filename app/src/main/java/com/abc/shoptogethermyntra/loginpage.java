package com.abc.shoptogethermyntra;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class loginpage extends AppCompatActivity {

    private static final String TAG = "loginpage";

    private TextView signuptxtbtn;
    private Button loginbtn;
    private EditText Email;
    private EditText Password;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginpage);

        mAuth = FirebaseAuth.getInstance();

        Email = findViewById(R.id.etLoginEmail);
        Password = findViewById(R.id.etLoginPassword);
        loginbtn = findViewById(R.id.btnLogin);
        signuptxtbtn = findViewById(R.id.signuptxtbtn);

        signuptxtbtn.setOnClickListener(view -> startActivity(new Intent(loginpage.this, signuppage.class)));

        loginbtn.setOnClickListener(view -> {
            String email = Email.getText().toString().trim();
            String password = Password.getText().toString().trim();
            if (!email.isEmpty() && !password.isEmpty()) {
                login(email, password);
            } else {
                Toast.makeText(loginpage.this, "Please enter email and password", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void login(String email, String password) {
        mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(this, task -> {
            if (task.isSuccessful()) {
                FirebaseUser user = mAuth.getCurrentUser();
                if (user != null) {
                    Log.d(TAG, "Login successful. User ID: " + user.getUid());
                    Intent intent = new Intent(this, MainActivity.class);
                    finish();
                    startActivity(intent);
                } else {
                    Log.e(TAG, "Login successful but user is null.");
                    Toast.makeText(this, "Login failed. User data is not available.", Toast.LENGTH_SHORT).show();
                }
            } else {
                Log.e(TAG, "Login failed: ", task.getException());
                Toast.makeText(this, "Login failed. Enter correct credentials.", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
