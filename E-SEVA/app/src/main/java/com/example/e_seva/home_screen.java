package com.example.e_seva;


import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;


/**
 * A simple {@link Fragment} subclass.
 */

public class home_screen<viewFlipper, fade_in> extends Fragment {
    private static final int REQUEST_CODE_LOCATION_PERMISSION=1;
CardView card1,card2,card3,card4,card5,card6;

    Animation slide_out_right,fade_in;
    ViewFlipper viewFlipper;



    public home_screen() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater , ViewGroup container ,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment



          View v=      inflater.inflate ( R.layout.fragment_home_screen , container , false );

card1=v.findViewById ( R.id.car1 );
card1.setOnClickListener ( new View.OnClickListener () {
    @Override
    public void onClick(View v) {

        startActivity ( new Intent ( getActivity (),complaint.class ) );
    }
} );

        card2=v.findViewById ( R.id.car2);
        card2.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                startActivity ( new Intent ( getActivity (),events.class ) );
            }
        } );

        card3=v.findViewById ( R.id.car3 );
        card3.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                startActivity ( new Intent ( getActivity (),Recruitment.class ) );
            }
        } );

        card4=v.findViewById ( R.id.car4 );
        card4.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                startActivity ( new Intent (getActivity(),women.class));
            }
        } );

        card5=v.findViewById ( R.id.car5 );
        card5.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                startActivity ( new Intent ( getActivity (),Envvironment.class ) );
            }
        } );

        card6=v.findViewById ( R.id.car6 );
        card6.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                startActivity ( new Intent ( getActivity (),corporator_info.class ) );
            }
        } );

//View fliper(fade in)

        viewFlipper = (ViewFlipper) v.findViewById(R.id.img);

        fade_in= AnimationUtils.loadAnimation(getActivity(), android.R.anim.fade_in);

        viewFlipper.setInAnimation(fade_in);

        viewFlipper.setAutoStart(true);
        viewFlipper.setFlipInterval(4000);
        viewFlipper.startFlipping();
        return v;


    }





}
