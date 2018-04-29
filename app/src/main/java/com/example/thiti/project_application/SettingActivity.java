package com.example.thiti.project_application;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class SettingActivity extends AppCompatActivity {

    TextView aboutus;
    TextView signOut;
    TextView account;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        aboutus = findViewById(R.id.aboutus);
        signOut = findViewById(R.id.logout);
        account = findViewById(R.id.account);

        aboutus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SettingActivity.this,aboutus.class));
            }
        });
        signOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(SettingActivity.this, LoginActivity.class);
                // After logging out, we need to clear all activity recoard.
                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

                startActivity(i);

            }
        });

        account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(SettingActivity.this, EditProfile.class);
                // After logging out, we need to clear all activity recoard.
                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

                startActivity(i);

            }
        });
    }
}
