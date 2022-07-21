package com.example.e_seva;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class harasment extends AppCompatActivity {
Button p1,p2,p3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_harasment );

        p1=findViewById(R.id.p1);
        p1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent=new Intent(harasment.this,policy.class);
                startActivity(intent);
            }
        });

        p2=findViewById(R.id.p2);
        p2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent=new Intent(harasment.this,safe_pdf.class);
                startActivity(intent);
            }
        });

        p3=findViewById(R.id.p3);
        p3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent=new Intent(harasment.this,svgc_pdf.class);
                startActivity(intent);
            }
        });
    }
}
