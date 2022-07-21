package com.example.e_seva;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

public class women extends AppCompatActivity {
CardView c1,c2,c3,c4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_women );



        c1=findViewById(R.id.c1);
        c1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent=new Intent(women.this,edp_training.class);
                startActivity(intent);
            }
        });

        c2=findViewById(R.id.c2);
        c2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent=new Intent(women.this,harasment.class);
                startActivity(intent);
            }
        });



        c3=findViewById(R.id.c3);
        c3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Web ="https://sbi.co.in/hi/web/personal-banking/investments-deposits/govt-schemes/sukanya-samriddhi-yojana";
                Intent webintent =new Intent(Intent.ACTION_VIEW, Uri.parse(Web));
                startActivity(webintent);

            }
        });

        c4=findViewById(R.id.c4);
        c4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Web ="https://www.goodreturns.in/classroom/2018/02/7-indian-government-schemes-women-empowerment-680804.html";
                Intent webintent =new Intent(Intent.ACTION_VIEW, Uri.parse(Web));
                startActivity(webintent);

            }
        });
    }
}
