package com.example.e_seva;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class safe_pdf extends AppCompatActivity {
    PDFView safe;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_safe_pdf );

        safe=(PDFView)findViewById(R.id.safe );
        safe.fromAsset("Safe.pdf" ).load ();
    }
}
