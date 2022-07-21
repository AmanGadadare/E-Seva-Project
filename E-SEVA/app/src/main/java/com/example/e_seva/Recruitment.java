package com.example.e_seva;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Recruitment extends AppCompatActivity {
Button gro1,gro2,gro3,gro4;
    Long contact1= 9082802260L;
    Long contact2= 8329605947L;
    Long contact3= 8369686562L;
    Long contact4= 8080380096L;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_recruitment );
        gro1=findViewById(R.id.groc1);
        gro1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent= new Intent(Intent.ACTION_DIAL);
                intent.setData( Uri.parse("tel:"+contact1));
                startActivity(intent);
            }
        });
        gro2=findViewById(R.id.groc2);
        gro2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent= new Intent(Intent.ACTION_DIAL);
                intent.setData( Uri.parse("tel:"+contact2));
                startActivity(intent);
            }
        });
        gro3=findViewById(R.id.groc3);
        gro3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent= new Intent(Intent.ACTION_DIAL);
                intent.setData( Uri.parse("tel:"+contact3));
                startActivity(intent);
            }
        });
        gro4=findViewById(R.id.groc4);
        gro4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent= new Intent(Intent.ACTION_DIAL);
                intent.setData( Uri.parse("tel:"+contact4));
                startActivity(intent);
            }
        });
    }
}
