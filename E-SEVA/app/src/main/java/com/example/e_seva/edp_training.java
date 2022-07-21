package com.example.e_seva;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class edp_training extends AppCompatActivity {
PDFView edp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_edp_training );
        edp=(PDFView)findViewById(R.id.edp );

        edp.fromAsset ( "proposal.pdf" ).load ();
    }
}
