package com.example.thiti.project_application;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

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
    private Button confirm;

    private String userid;
    DatabaseReference databaseref;
    FirebaseAuth mAuth;

    private String firstname;
    private String lastname;
    private String school;
    private String age;




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


        FirebaseUser currentUser = mAuth.getCurrentUser();


        userid = currentUser.getUid();

        databaseref = FirebaseDatabase.getInstance().getReference().child("Users").child(userid);


        databaseref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Map map = (Map)dataSnapshot.getValue();
                String Firstname = String.valueOf(map.get("age"));

               /* String Lastname = value.getLongDesc();
                String school = value.getLinkImg();
                String age = value.getLongDesc();
                String phone = value.getLinkImg();*/
                input_firstname.setText(Firstname);

                }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });






    }
}
