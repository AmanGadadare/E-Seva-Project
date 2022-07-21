package com.example.e_seva;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class forgot_pass extends AppCompatActivity {
    EditText resendemail;
    CardView resetpassword;
    private  FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_pass);
        resetpassword =findViewById(R.id.resetpassword);
        resendemail =findViewById(R.id.resendemail);
        firebaseAuth = FirebaseAuth.getInstance();

        resetpassword.setOnClickListener(new View.OnClickListener() {
            @Override
                public void onClick (View v){
                String reemail = resendemail.getText().toString();

                firebaseAuth.sendPasswordResetEmail(reemail).addOnCompleteListener(forgot_pass.this, new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(forgot_pass.this, "Password sent to your Email", Toast.LENGTH_LONG).show();
                            //finish();
                        } else {
                            Toast.makeText(forgot_pass.this, "Invalid Email", Toast.LENGTH_LONG).show();
                            // finish();
                        }
                    }
                });
         }
  });
  }

}

