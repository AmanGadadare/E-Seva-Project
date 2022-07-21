package com.example.e_seva;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Envvironment extends AppCompatActivity {
Button p1;
TextView corona;
    Long contact11=  020-26127394L;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_envvironment );

        p1=findViewById(R.id.p11);
        p1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent= new Intent(Intent.ACTION_DIAL);
                intent.setData( Uri.parse("tel:"+contact11));
                startActivity(intent);
            }
        });


        corona=(TextView)findViewById(R.id.corona);
        corona.setSelected(true);
        corona.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Web ="https://www.mygov.in/covid-19";
                Intent webintent =new Intent(Intent.ACTION_VIEW, Uri.parse(Web));
                startActivity(webintent);

            }
        });
    }
}
