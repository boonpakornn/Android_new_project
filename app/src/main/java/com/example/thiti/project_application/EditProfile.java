package com.example.thiti.project_application;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Map;

public class EditProfile extends AppCompatActivity {


    //Variable Edittext

    private EditText input_firstname;
    private EditText input_lastname;
    private EditText input_school;
    private EditText input_age;
    private EditText input_phone;


    private String userid;
    private DatabaseReference databaseref;
    private FirebaseAuth mAuth;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);


        //Refer to xml activity

        input_firstname = findViewById(R.id.edit_firstname);
        input_lastname = findViewById(R.id.edit_lastname);
        input_school = findViewById(R.id.edit_school);
        input_age = findViewById(R.id.edit_age);
        input_phone = findViewById(R.id.edit_phone);


        Button btnclick = (Button) findViewById(R.id.Editbutton);
        Button cancelclick = (Button) findViewById(R.id.cancelClick);


        mAuth = FirebaseAuth.getInstance();

        FirebaseUser currentUser = mAuth.getCurrentUser();


        userid = currentUser.getUid();

        databaseref = FirebaseDatabase.getInstance().getReference().child("Users").child(userid);


        databaseref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Map map = (Map)dataSnapshot.getValue();
                String Firstname = String.valueOf(map.get("firstname"));
                String Lastname =  String.valueOf(map.get("lastname"));

                String school =  String.valueOf(map.get("school"));
                String age =  String.valueOf(map.get("age"));
                String phone =  String.valueOf(map.get("phone"));

                input_firstname.setText(Firstname);
                input_lastname.setText(Lastname);

                input_school.setText(school);
                input_age.setText(age);
                input_phone.setText(phone);


                }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }




        });

        btnclick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newFirstname = input_firstname.getText().toString().trim();
                String newLastname = input_lastname.getText().toString().trim();
                String newSchool = input_school.getText().toString().trim();
                String newAge = input_age.getText().toString().trim();
                String newPhone = input_phone.getText().toString().trim();

                databaseref.child("firstname").setValue(newFirstname);
                databaseref.child("Users").child(userid).child("lastname").setValue(newLastname);
                databaseref.child("school").setValue(newSchool);
                databaseref.child("Users").child(userid).child("age").setValue(newAge);
                databaseref.child("phone").setValue(newPhone);

                Toast.makeText(EditProfile.this, "Successfully updated user's information.", Toast.LENGTH_LONG).show();


            }
        });

        cancelclick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(EditProfile.this, SettingActivity.class));

            }
        });



    }
    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
    }
}
