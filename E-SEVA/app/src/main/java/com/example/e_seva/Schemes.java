package com.example.e_seva;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class Schemes extends Fragment {


    public Schemes() {
        // Required empty public constructor
    }

CardView s1,s2,s3;
    @Override
    public View onCreateView(LayoutInflater inflater , ViewGroup container ,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        View v=      inflater.inflate ( R.layout.fragment_schemes, container , false );

        s1=v.findViewById ( R.id.schme1 );
        s1.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                String Web ="https://www.grainmart.in/news/india-launches-the-biggest-food-ration-subsidy-scheme-in-the-world-amid-coronavirus-lockdown/";
                Intent webintent =new Intent(Intent.ACTION_VIEW, Uri.parse(Web));
                startActivity(webintent);

            }
        } );

        s2=v.findViewById ( R.id.schme2);
        s2.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                startActivity ( new Intent ( getActivity (),echo_housing.class ) );
            }
        } );

        s3=v.findViewById ( R.id.schme33);
        s3.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                String Web ="https://www.aicte-india.org/schemes/students-development-schemes";
                Intent webintent =new Intent(Intent.ACTION_VIEW, Uri.parse(Web));
                startActivity(webintent);

            }
        } );
        return v;
    }

}
