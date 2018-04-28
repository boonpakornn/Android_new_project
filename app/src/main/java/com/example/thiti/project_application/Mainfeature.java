package com.example.thiti.project_application;





import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

public class Mainfeature extends AppCompatActivity {

    ImageButton newsAndEventsButton;    //Button to News & Projects from homepage
    ImageButton admissionCalculator;    //Button to Admission Calculator from homepage
    ImageButton setting;                //Button to Setting from homepage
    ImageButton calendarView;           //Button to Calendar from homepage

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainfeature);

        //set the button value from button in xml files.
        newsAndEventsButton = findViewById(R.id.news_and_events_button);
        admissionCalculator = findViewById(R.id.admission_cal_button);
        setting = findViewById(R.id.settings_button);
        calendarView = findViewById(R.id.location_button);

        //set the intent to each feature according to buttons.
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

        setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Mainfeature.this, SettingActivity.class));
            }
        });

        calendarView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Mainfeature.this, MapsActivity.class));
            }
        });
    }
}

