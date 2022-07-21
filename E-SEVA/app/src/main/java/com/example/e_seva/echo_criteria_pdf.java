package com.example.e_seva;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class echo_criteria_pdf extends AppCompatActivity {
PDFView ag2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_echo_criteria_pdf );

        ag2=(PDFView)findViewById ( R.id.ag2 );
        ag2.fromAsset("echo_criteria.pdf" ).load ();

    }
}
