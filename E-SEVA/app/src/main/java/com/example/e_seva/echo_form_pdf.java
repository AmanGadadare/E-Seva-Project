package com.example.e_seva;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class echo_form_pdf extends AppCompatActivity {
PDFView ag3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_echo_form_pdf );

        ag3=(PDFView)findViewById(R.id.ag3);
        ag3.fromAsset("reg_form.pdf" ).load ();
    }
}
