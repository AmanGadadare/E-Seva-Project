package com.example.e_seva;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class complaint extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Spinner Area_from_comp,complainttype;
    String sub_ward;
    String comp_type;
    Button register;
    EditText name,address_person,descrip;
    ProgressBar comp_progress;
    private FirebaseFirestore db;
    private FirebaseAuth firebaseAuth;
    private FirebaseUser firebaseUser;
    private static final String KEY_USERNAME = "Username";
    private static final String KEY_DESCRIPTION = "Description";
    private static final String KEY_AREA = "Area";
    private static final String KEY_ADDRESS = "Address";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_complaint );
        
        db =FirebaseFirestore.getInstance();
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseUser = firebaseAuth.getCurrentUser();
        Area_from_comp = findViewById(R.id.Area_complaint);
        complainttype=findViewById(R.id.complaint_type);
        name =findViewById(R.id.name);
        address_person =findViewById(R.id.address);
        descrip = findViewById(R.id.description);
        register =findViewById(R.id.register);
        comp_progress =findViewById(R.id.comp_progress);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.complaints_types, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        complainttype.setAdapter(adapter);
        complainttype.setOnItemSelectedListener(this);
        complainttype.setPrompt("Select Complaint Type");
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this,
                R.array.Area_from, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Area_from_comp.setAdapter(adapter1);
        Area_from_comp.setOnItemSelectedListener(this);
        Area_from_comp.setPrompt("Select Your Area");


    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if(parent.getId() == R.id.Area_complaint){
            String area_from_where = parent.getItemAtPosition(position).toString();
            if(area_from_where.toString().equals("Thankur Complex") || area_from_where.toString().equals("Thakur Village") ||
                    area_from_where.toString().equals("Lokhandwala Complex") ||area_from_where.toString().equals("Patel nagar")
                    || area_from_where.toString().equals("MG Road Kandivali") || area_from_where.toString().equals("Mathuradas Road")||area_from_where.equals("Damupada")
                    || area_from_where.equals("Charkop Khade")||area_from_where.equals("Hanuman Nagar")||area_from_where.equals("Poisar River")||area_from_where.equals("Mahavir Nagar")
                    ||area_from_where.equals("Miiltary Road")||area_from_where.equals("Lala Lajapatrai Road")||area_from_where.equals("Khajura Talov Road")||area_from_where.equals("Ganesh Nagar")
                    ||area_from_where.equals("FCI")||area_from_where.equals("Samata Nagar")||area_from_where.equals("Kandivali Fire Station")){
                sub_ward = "R South";
            }
            else if(area_from_where.equals("Dahisar") || area_from_where.equals("Poisar Depot")||area_from_where.equals("Dhaisar Check Naka")){
                sub_ward = "R North";

            }
            else if(area_from_where.equals("Oshiwara") || area_from_where.equals("Goregoan")){
                sub_ward="P South";

            }
            else if(area_from_where.equals("Malad Station") || area_from_where.equals("Chincholi Bunder Road")||area_from_where.equals("Malvani")
                    || area_from_where.equals("Marve Road")|| area_from_where.equals("Gen.Vaidya Marg")||area_from_where.equals("Kurar Village(East)")||
                        area_from_where.equals("Madh(West)")){
                sub_ward = "P North";

            }
            else {
                Toast.makeText(this, "Something Went Wrong Please try Again", Toast.LENGTH_SHORT).show();
            }


        }
        else if(parent.getId() == R.id.complaint_type){
            String comp_type = parent.getItemAtPosition(position).toString();
        }
        else{
            Toast.makeText(this, "Something Went Wrong ,Please Try Again ", Toast.LENGTH_SHORT).show();
        }


    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void Register_Complaint(View view) {
        String comp_type= complainttype.getSelectedItem().toString();
        String address = Area_from_comp.getSelectedItem().toString();
        String username = name.getText().toString();
        String address_per = address_person.getText().toString();
        String Descrip = descrip.getText().toString();
        Map<String, Object> note = new HashMap<>();
        note.put(KEY_USERNAME,username);
        note.put(KEY_AREA,address);
        note.put(KEY_ADDRESS,address_per);
        note.put(KEY_DESCRIPTION,Descrip);
        comp_progress.setVisibility(View.VISIBLE);
        db.collection("Complaints").document(comp_type).collection(sub_ward).document().set(note).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                comp_progress.setVisibility(View.INVISIBLE);
                Toast.makeText(complaint.this, "Your Complaint is Register SuccessFully", Toast.LENGTH_SHORT).show();
                Toast.makeText(complaint.this, "Thank You", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(complaint.this,home_screenn.class));
                Intent intenthome = new Intent(complaint.this, home_screenn.class);
                intenthome.addFlags(intenthome.FLAG_ACTIVITY_CLEAR_TOP);
                intenthome.addFlags(intenthome.FLAG_ACTIVITY_CLEAR_TASK);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(complaint.this, "Complaint Registration Failed please Try Again", Toast.LENGTH_SHORT).show();

            }
        });


    }







    }

