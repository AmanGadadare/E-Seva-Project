package com.example.e_seva;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class echo_house_pdf extends AppCompatActivity {
PDFView ag1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_echo_house_pdf );


        ag1=(PDFView)findViewById ( R.id.ag1 );
        ag1.fromAsset("house.pdf" ).load ();
    }
}
