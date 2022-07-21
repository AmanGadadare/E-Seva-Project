package com.example.e_seva;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class policy extends AppCompatActivity {
    PDFView policy;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_policy );

        policy=(PDFView)findViewById( R.id.policy);
        policy.fromAsset("policy.pdf" ).load ();
    }
}
