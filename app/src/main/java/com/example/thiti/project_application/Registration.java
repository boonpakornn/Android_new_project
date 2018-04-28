package com.example.thiti.project_application;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
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

    //Variable Edittext
    private EditText input_username;
    private EditText input_pass;
    private EditText input_repassword;
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

        //Refer to xml activity
        input_username = findViewById(R.id.username);
        input_pass = findViewById(R.id.password);
        input_repassword=  findViewById(R.id.repassword);
        input_firstname = findViewById(R.id.firstname);
        input_lastname = findViewById(R.id.lastname);
        input_school = findViewById(R.id.school);
        input_age = findViewById(R.id.age);
        input_phone = findViewById(R.id.phone);
        progressBar = findViewById(R.id.progressBar);
        progressBar.setVisibility(View.GONE);




        Button btnclick = (Button) findViewById(R.id.button2);

        // Connect to Firebase for Authentication
        mAuth = FirebaseAuth.getInstance();



        // When button2 is clicked, It will be call registerationUser function.
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

    protected void onStart() {
        super.onStart();

        if (mAuth.getCurrentUser() != null) {
            //handle thid already login user

        }
    }

    private void registerationUser() {

        //Get all vriables from activity registeration
        final String username = input_username.getText().toString().trim();
        final String password = input_pass.getText().toString().trim();
        final String repassword = input_repassword.getText().toString().trim();
        final String Firstname = input_firstname.getText().toString().trim();
        final String Lastname = input_lastname.getText().toString().trim();
        final String school = input_lastname.getText().toString().trim();
        final String age = input_age.getText().toString().trim();
        final String phone = input_phone.getText().toString().trim();


        // Checking username


        if (username.isEmpty()) {
            input_username.setError("Username is required");
            input_username.requestFocus();
            return;
        }

        // Check email format
        if (!Patterns.EMAIL_ADDRESS.matcher(username).matches()) {
            input_username.setError("Enter a valid  email");
            input_username.requestFocus();
            return;
        }

        //Checking Password error
        if (password.isEmpty()) {
            input_pass.setError(getString(R.string.error_invalid_password));
            input_pass.requestFocus();
            return;
        }

        // Password must longer than 6 characters.
        if (password.length() < 6) {
            input_pass.setError("Password should be atleast 6 characters.");
            input_pass.requestFocus();
            return;
        }

        if (repassword.isEmpty()) {
            input_pass.setError("Re-password is required");
            input_pass.requestFocus();
            return;
        }

        // Checking for password matched.
        if (!repassword.matches(password)) {
            input_pass.setError("Password should be matched.");
            input_pass.requestFocus();
            return;
        }

        //Requiered input  for Firstname
        if (Firstname.isEmpty()) {
            input_firstname.setError("Firstname is required.");
            input_firstname.requestFocus();
            return;
        }

        //Requiered input  for Lastname
        if (Lastname.isEmpty()) {
            input_lastname.setError("Lastname is required.");
            input_lastname.requestFocus();
            return;
        }

        //Requiered input  for School
        if (school.isEmpty()) {
            input_school.setError("School is required.");
            input_school.requestFocus();
            return;
        }

        //Requiered input  for age
        if (age.isEmpty()) {
            input_age.setError("Age is required.");
            input_age.requestFocus();
            return;
        }


        progressBar.setVisibility(View.VISIBLE);
        mAuth.createUserWithEmailAndPassword(username, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {

            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                progressBar.setVisibility((View.GONE));

                if (task.isSuccessful()) {

                    //We will store the additional in firebase database.


                    User user = new User(username, Firstname, Lastname, school, age, phone);

                    //It will go to "Users" path folder on Firebase database and create folder named by user ID
                    FirebaseDatabase.getInstance().getReference("Users").child(FirebaseAuth.getInstance().getCurrentUser().getUid()).setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(Registration.this, getString(R.string.registra), Toast.LENGTH_LONG).show();
                                // Forced user after log in sucess, go to login activity
                                startActivity(new Intent(Registration.this, LoginActivity.class));
                            } else {
                                //Display failuremessage
                                if (task.getException() instanceof FirebaseAuthUserCollisionException) {
                                    Toast.makeText(Registration.this, "You are already registered.", Toast.LENGTH_LONG).show();


                                    //Show when somthing got error

                                } else {
                                    Toast.makeText(Registration.this, task.getException().getMessage(), Toast.LENGTH_LONG).show();

                                }
                            }
                        }
                    });

                } else {
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



}
