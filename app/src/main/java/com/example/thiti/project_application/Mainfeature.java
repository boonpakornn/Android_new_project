package com.example.thiti.project_application;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.google.firebase.FirebaseApp;

public class Mainfeature extends AppCompatActivity {

    ImageButton newsAndEventsButton;    //Button to News & Projects from homepage
    ImageButton admissionCalculator;    //Button to Admission Calculator from homepage

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainfeature);

        newsAndEventsButton = findViewById(R.id.news_and_events_button);
        admissionCalculator = findViewById(R.id.admission_cal_button);

        newsAndEventsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Mainfeature.this, NewsandEvent.class));
            }
        });

        admissionCalculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Mainfeature.this, AdmissionCalculator.class));
            }
        });
    }

}
