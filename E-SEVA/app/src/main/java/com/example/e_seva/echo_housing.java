package com.example.e_seva;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class echo_housing extends AppCompatActivity {
TextView house,criteria,form,link;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_echo_housing );

        house=findViewById(R.id.house);
        house.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent=new Intent(echo_housing.this,echo_house_pdf.class);
                startActivity(intent);
            }
        });

        criteria=findViewById(R.id.criteria);
        criteria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent=new Intent(echo_housing.this,echo_criteria_pdf.class);
                startActivity(intent);
            }
        });

        form=findViewById(R.id.form);
        form.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent=new Intent(echo_housing.this,echo_form_pdf.class);
                startActivity(intent);
            }
        });




        link=findViewById(R.id.link);
        link.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Web ="portal.mcgm.gov.in/irj/portal/anonymous/qlecohousing";
                Intent webintent =new Intent(Intent.ACTION_VIEW, Uri.parse(Web));
                startActivity(webintent);

            }
        });
    }
}
