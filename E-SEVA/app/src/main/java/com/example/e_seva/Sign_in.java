package com.example.e_seva;



import android.app.IntentService;
import android.content.Intent;

import android.support.annotation.NonNull;

import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;


public class Sign_in extends AppCompatActivity implements View.OnClickListener {

    CardView signbutton, googlesignin;
    private GoogleSignInClient mGoogleSignInClient;


    private int RC_SIGN_IN = 1;
    EditText  emailtxt, passwordtxt;
            TextView forgotpassword,signuptxt,username;
        String st;
    private FirebaseAuth firebaseAuth;
    private FirebaseUser firebaseUser;
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    ProgressBar signinprogressbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        signbutton = findViewById(R.id.signinbutton);
        signuptxt = findViewById(R.id.signuptxt);
        emailtxt = findViewById(R.id.signinemailtxt);
        passwordtxt = findViewById(R.id.signinpasswordtxt);
        forgotpassword = findViewById(R.id.forgotpassword);
        googlesignin = findViewById(R.id.googlesignin);
        signinprogressbar = findViewById(R.id.signinprogress);
        username = findViewById(R.id.username);

         firebaseAuth = FirebaseAuth.getInstance();
        firebaseUser = firebaseAuth.getCurrentUser();

        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);

        signuptxt.setOnClickListener(this);
        signbutton.setOnClickListener(this);
        forgotpassword.setOnClickListener(this);
        googlesignin.setOnClickListener(this);

        if(firebaseUser != null){
            startActivity(new Intent(Sign_in.this,home_screenn.class));
            Toast.makeText(this,"Welcome Back" , Toast.LENGTH_SHORT).show();
        }


    }

    private void login(final String txt_email, String txt_password) {
        try {
            if (txt_email.matches(emailPattern)) {

                firebaseAuth.signInWithEmailAndPassword(txt_email, txt_password)
                        .addOnCompleteListener(Sign_in.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                signinprogressbar.setVisibility(View.INVISIBLE);
                                if (task.isSuccessful()) {
                                    Intent intenthome = new Intent(Sign_in.this, home_screenn.class);
                                    intenthome.addFlags(intenthome.FLAG_ACTIVITY_CLEAR_TOP);
                                    intenthome.addFlags(intenthome.FLAG_ACTIVITY_CLEAR_TASK);
                                    startActivity(intenthome);

                                    // intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                } else {
                                    Toast.makeText(Sign_in.this, "Login Failed", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            } else {
                Toast.makeText(Sign_in.this, "Enter Valid Email", Toast.LENGTH_LONG).show();
            }
        } catch (Exception e) {
            Toast.makeText(Sign_in.this, e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.signinbutton:
                signinprogressbar.setVisibility(View.VISIBLE);
                String txt_email = emailtxt.getText().toString();
                String txt_password = passwordtxt.getText().toString();
                if (TextUtils.isEmpty(txt_email) || TextUtils.isEmpty(txt_password)) {
                    Toast.makeText(Sign_in.this, "Empty credentials!", Toast.LENGTH_SHORT).show();
                } else if (txt_password.length() < 6) {
                    Toast.makeText(Sign_in.this, "Password too short!", Toast.LENGTH_SHORT).show();
                } else {

                    login(txt_email, txt_password);
                }


                break;
            case R.id.signuptxt:
                Intent intent = new Intent(Sign_in.this, Sign_up.class);
                startActivity(intent);
                break;
            case R.id.forgotpassword:
                Intent i = new Intent(Sign_in.this, forgot_pass.class);
                startActivity(i);
                break;
            case R.id.googlesignin:

                signingoogle();






        }
    }

         private void signingoogle() {
             signinprogressbar.setVisibility(View.VISIBLE);
        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RC_SIGN_IN) {
            signinprogressbar.setVisibility(View.INVISIBLE);
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            handleSignInResult(task);
        }
    }

    private void handleSignInResult(Task<GoogleSignInAccount> task) {
        try {

            GoogleSignInAccount acc = task.getResult(ApiException.class);
            Toast.makeText(Sign_in.this, "Signed In Successfully", Toast.LENGTH_SHORT).show();
            FirebaseGoogleAuth(acc);
        } catch (ApiException e) {
            Toast.makeText(Sign_in.this, "Sign In Failed", Toast.LENGTH_SHORT).show();
            FirebaseGoogleAuth(null);
        }
    }

    private void FirebaseGoogleAuth(GoogleSignInAccount acc) {
        if (acc != null) {
            AuthCredential authCredential = GoogleAuthProvider.getCredential(acc.getIdToken(), null);
            firebaseAuth.signInWithCredential(authCredential).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {

                    if (task.getException() instanceof FirebaseAuthUserCollisionException) {
                        Toast.makeText(Sign_in.this, "Email Address Already Registered", Toast.LENGTH_LONG).show();
                        finish();
                    }
                    else if (task.isSuccessful()) {
                        FirebaseUser user = firebaseAuth.getCurrentUser();
                        updateUI(user);
                        Intent intenthome = new Intent(Sign_in.this, home_screenn.class);
                        startActivity(intenthome);

                    } else {
                        Toast.makeText(Sign_in.this, "Failed", Toast.LENGTH_SHORT).show();
                        updateUI(null);
                    }
                }
            });
        } else {
            Toast.makeText(Sign_in.this, "acc failed", Toast.LENGTH_SHORT).show();
        }
    }

    private void updateUI(FirebaseUser fUser) {

        GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(getApplicationContext());
        if (account != null) {
            String personName = account.getDisplayName();
            Toast.makeText(Sign_in.this, "welcome" +personName, Toast.LENGTH_SHORT).show();
        }
    }
}



