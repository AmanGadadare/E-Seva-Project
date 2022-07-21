package com.example.e_seva;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;

public class Sign_up extends AppCompatActivity {

    private FirebaseAuth firebaseAuth;
    EditText emailtxt, passwordtxt;
    CardView signupbuton;

    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        signupbuton = findViewById(R.id.signupbutton);
        emailtxt = findViewById(R.id.signupemailtxt);
        passwordtxt = findViewById(R.id.signuppasswordtxt);
        progressBar =findViewById(R.id.signupprogress);
        firebaseAuth = FirebaseAuth.getInstance();

            signupbuton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String txt_email = emailtxt.getText().toString();
                    String txt_password = passwordtxt.getText().toString();
                     progressBar.setVisibility(View.VISIBLE);
                    if (TextUtils.isEmpty(txt_email) || TextUtils.isEmpty(txt_password)) {
                        Toast.makeText(Sign_up.this, "Empty credentials!", Toast.LENGTH_SHORT).show();
                    } else if (txt_password.length() < 6) {
                        Toast.makeText(Sign_up.this, "Password too short!", Toast.LENGTH_SHORT).show();
                    } else {
                        registerUser(txt_email, txt_password);
                    }
                }
            });





    }

    private void registerUser(String emailtxt, String passwordtxt) {


        if (emailtxt.matches(emailPattern)) {


            firebaseAuth.createUserWithEmailAndPassword(emailtxt, passwordtxt)
                    .addOnCompleteListener(Sign_up.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            progressBar.setVisibility(View.INVISIBLE);
                            if (task.getException() instanceof FirebaseAuthUserCollisionException) {
                                Toast.makeText(Sign_up.this, "Email Address Already Registered", Toast.LENGTH_LONG).show();
                            }
                            if (task.isSuccessful()) {

                                Intent intent = new Intent(getApplicationContext(), home_screenn.class);
                                startActivity(intent);
                                Toast.makeText(Sign_up.this, "Registration Sucessfull", Toast.LENGTH_LONG).show();
                                // startActivity(new Intent(Sign_up.this,home_screenn.class));


                            } else {
                                Toast.makeText(Sign_up.this, "Login Error", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
        } else {
            Toast.makeText(Sign_up.this, "Invailed Email , PLS Enter Valid Email", Toast.LENGTH_LONG).show();
        }


    }
}

