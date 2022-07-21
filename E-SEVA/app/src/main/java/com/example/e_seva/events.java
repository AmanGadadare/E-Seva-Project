package com.example.e_seva;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.TextView;

public class events extends AppCompatActivity {
CardView blod ,mar;
TextView link;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_events );
        blod=findViewById ( R.id.blodd);
        blod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent=new Intent(events.this,blood_donation.class);
                startActivity(intent);
            }
        });
        mar=findViewById ( R.id.marath);
        mar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent=new Intent(events.this,Marathon.class);
                startActivity(intent);
            }
        });

        link=findViewById(R.id.eventlink);
        link.setSelected ( true );
        link.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Web ="https://economictimes.indiatimes.com/news/politics-and-nation/maharashtra-shuts-down-theatres-gyms-swimming-pools/articleshow/74621313.cms?from=mdr";
                Intent webintent =new Intent(Intent.ACTION_VIEW, Uri.parse(Web));
                startActivity(webintent);

            }
        });

    }
}
