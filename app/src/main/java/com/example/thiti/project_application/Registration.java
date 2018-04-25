package com.example.thiti.project_application;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.messaging.FirebaseMessaging;


public class Registration extends AppCompatActivity {
    private static final String TAG = "Registration";
    private EditText input_username;
    private EditText input_pass;
    private EditText input_email;
    private EditText input_firstname;
    private EditText input_lastname;
    private EditText input_school;
    private EditText input_age;
    private EditText input_phone;
    private Button confirm;

    private ProgressBar progressBar;

    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registeration);


        input_username = findViewById(R.id.username);
        input_pass = findViewById(R.id.password);
        //input_email=  findViewById(R.id.email);
        input_firstname =  findViewById(R.id.firstname);
        input_lastname = findViewById(R.id.lastname);
        input_school  =  findViewById(R.id.school);
        input_age =  findViewById(R.id.age);
        input_phone =  findViewById(R.id.phone);
        progressBar = findViewById(R.id.progressBar);
        progressBar.setVisibility(View.GONE);

        input_username.setText("mail@mail.com");
        input_pass.setText("1233456");
        input_firstname.setText("first");
        input_lastname.setText("last");
        input_school.setText("scchool");
        input_age.setText("66");
        input_phone.setText("0999999999");

        Button btnclick = (Button)findViewById(R.id.button2);
        mAuth = FirebaseAuth.getInstance();


        //btnclick.setOnClickListener(new View.OnClickListener(this));

        btnclick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.button2:
                        registerationUser();
                        break;
                    default:
                        break;
                }
            }
        });
        /*
        */

        }

    protected void onStart(){
        super.onStart();

        if(mAuth.getCurrentUser()!=null){
            //handle thid already login user

        }
    }

    public void subscribe(View view) {
        // สับตะไคร้หัวข้อ news
        FirebaseMessaging.getInstance().subscribeToTopic("news");

    }

    private void registerationUser(){

        final String username = input_username.getText().toString().trim();
        final String password= input_pass.getText().toString().trim();
        final String Firstname = input_firstname.getText().toString().trim();
        final String Lastname = input_lastname.getText().toString().trim();
        final String school = input_lastname.getText().toString().trim();
        final String age = input_age.getText().toString().trim();
        final String phone = input_phone.getText().toString().trim();




        // Username
        if(username.isEmpty()){
            input_username.setError(getString(R.string.error_invalid_email));
            input_username.requestFocus();
            return;
        }

        if(username.isEmpty()){
            input_username.setError("Username is required");
            input_username.requestFocus();
            return;
        }

        if(!Patterns.EMAIL_ADDRESS.matcher(username).matches()){
            input_username.setError("Enter a valid  email");
            input_username.requestFocus();
            return;
        }

        //Password

        if(password.isEmpty()){
            input_pass.setError(getString(R.string.error_invalid_password));
            input_pass.requestFocus();
            return;
        }

        if(password.length()<6){
            input_pass.setError("Password should be atleast 6 characters.");
            input_pass.requestFocus();
            return;
        }
        //Firstname
        if(Firstname.isEmpty()){
            input_firstname.setError("Firstname is requored.");
            input_firstname.requestFocus();
            return;
        }

        //Lastname
        if(Lastname.isEmpty()){
            input_lastname.setError("Lastname is requored.");
            input_lastname.requestFocus();
            return;
        }

        //School
        if(school.isEmpty()){
            input_school.setError("School is requored.");
            input_school.requestFocus();
            return;
        }

        if(age.isEmpty()){
            input_age.setError("Age is requored.");
            input_age.requestFocus();
            return;
        }


        progressBar.setVisibility(View.VISIBLE);
        mAuth.createUserWithEmailAndPassword(username, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {

            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                progressBar.setVisibility((View.GONE));

                if(task.isSuccessful()){
                    //We will store the additional in firebase database.


                    System.out.print("Do");
                    User user = new User(username, Firstname, Lastname, school, age, phone);

                    FirebaseDatabase.getInstance().getReference("Users").child(FirebaseAuth.getInstance().getCurrentUser().getUid()).setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(Registration.this, getString(R.string.registra), Toast.LENGTH_LONG).show();
                            } else {
                                //Display failuremessage
                                if(task.getException() instanceof FirebaseAuthUserCollisionException){
                                    Toast.makeText(Registration.this,"You are already registered.", Toast.LENGTH_LONG).show();

                                }else{
                                    Toast.makeText(Registration.this,task.getException().getMessage(), Toast.LENGTH_LONG).show();

                                }
                            }
                        }
                    });

                }else{
                    Toast.makeText(Registration.this, task.getException().getMessage(), Toast.LENGTH_LONG).show();
                }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                e.printStackTrace();
            }
        });

        


        }

    private void facebooklogin(){



    }
                








}
