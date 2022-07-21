package com.example.e_seva;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.CardView;
import android.view.View;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.MenuItem;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class home_screenn extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
TextView navsend,username,emailtxt,passwordtxt;
private FirebaseAuth firebaseAuth;
private FirebaseUser firebaseUser;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


       setContentView(R.layout.activity_home_screenn);

        Toolbar toolbar = findViewById(R.id.toolbar);
        username = findViewById(R.id.username);

        firebaseAuth = FirebaseAuth.getInstance();
        firebaseUser = firebaseAuth.getCurrentUser();
        username =findViewById(R.id.username);



        setSupportActionBar(toolbar);







        TabLayout tabLayout =(TabLayout)findViewById(R.id.tabs);

        ViewPager Pager =(ViewPager)findViewById(R.id.viewpager);



        tabpagerAdapter Tabpageradapter = new tabpagerAdapter(getSupportFragmentManager());

        Pager.setAdapter(Tabpageradapter);

        tabLayout.setupWithViewPager(Pager);
  DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);

        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
          /* Intent intent = getIntent();
        String str = intent.getStringExtra("username");
        username.setText(str);*/
        getMenuInflater().inflate(R.menu.home_screenn, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            firebaseAuth.signOut();

            Intent intent = new Intent(home_screenn.this,Sign_in.class);
            intent.addFlags(intent.FLAG_ACTIVITY_CLEAR_TOP);
           // intent.addFlags(intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
            Toast.makeText(home_screenn.this,"Your Sign Out Now",Toast.LENGTH_LONG).show();
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.myBMC) {


                try{
                    startActivity(new Intent(Intent.ACTION_VIEW,
                            Uri.parse("market://details?id=" + " in.cdac.gov.mgov.mcgm")));

                }catch (ActivityNotFoundException e){
                    startActivity(new Intent(Intent.ACTION_VIEW,
                            Uri.parse("http://play.google.com/store/apps/details?id=" + getPackageName())));

                }






        } else if (id == R.id.pothole) {
            try{
                startActivity(new Intent(Intent.ACTION_VIEW,
                        Uri.parse("market://details?id=" + " com.probity.pothole")));

            }catch (ActivityNotFoundException e){
                startActivity(new Intent(Intent.ACTION_VIEW,
                        Uri.parse("http://play.google.com/store/apps/details?id=" + getPackageName())));

            }





        } else if (id == R.id.kyc) {
            try{
                startActivity(new Intent(Intent.ACTION_VIEW,
                        Uri.parse("market://details?id=" + "in.kjstudios.mumbaikyc")));

            }catch (ActivityNotFoundException e){
                startActivity(new Intent(Intent.ACTION_VIEW,
                        Uri.parse("http://play.google.com/store/apps/details?id=" + getPackageName())));

            }







      } else if (id == R.id.mcgm) {

            try{
                startActivity(new Intent(Intent.ACTION_VIEW,
                        Uri.parse("market://details?id=" + "com.esri.app4353f81228894dc6a3e1068e85eeca77")));

            }catch (ActivityNotFoundException e){
                startActivity(new Intent(Intent.ACTION_VIEW,
                        Uri.parse("http://play.google.com/store/apps/details?id=" + getPackageName())));

            }




        } else if (id == R.id.about) {
            Intent intent=new Intent(home_screenn.this,about_us.class);
            startActivity(intent);


        }
        else{
            Toast.makeText(home_screenn.this,"Error",Toast.LENGTH_LONG).show();
        }


        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;

    }
}
