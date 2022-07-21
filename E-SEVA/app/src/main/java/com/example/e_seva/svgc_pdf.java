package com.example.e_seva;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class svgc_pdf extends AppCompatActivity {
    PDFView svgc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_svgc_pdf );

        svgc=(PDFView)findViewById( R.id.svgc );
        svgc.fromAsset("svgc.pdf" ).load ();
    }
}
