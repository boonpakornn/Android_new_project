package com.example.thiti.project_application;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import com.google.firebase.messaging.FirebaseMessaging;

import java.util.Map;
import java.util.Set;

public class SettingActivity extends AppCompatActivity {

    TextView aboutus;
    TextView signOut;
    TextView account;
    Switch noti;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        aboutus = findViewById(R.id.aboutus);
        signOut = findViewById(R.id.logout);
        account = findViewById(R.id.account);

        noti = findViewById(R.id.switch1);

        aboutus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SettingActivity.this, aboutus.class));
            }
        });
        //Click to signout
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

        // Button to turn on and turn off nontifiction.
        //Nontification might delay depending on Firebase server.
        noti.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked)
                    FirebaseMessaging.getInstance().subscribeToTopic("Recieveinformation");
                else
                    FirebaseMessaging.getInstance().unsubscribeFromTopic("Recieveinformation");
                SharedPreferences sharedPreferences = getSharedPreferences("settings", Context.MODE_PRIVATE);
                sharedPreferences.edit().putBoolean("receiveNotification", isChecked).apply();
            }
        });

        //This will maintain state of switch button. when users go to another page and come back, the switch is still checked.
        SharedPreferences sharedPreferences = getSharedPreferences("settings", Context.MODE_PRIVATE);
        noti.setChecked(sharedPreferences.getBoolean("receiveNotification", true));
        if (noti.isChecked())
            FirebaseMessaging.getInstance().subscribeToTopic("Recieveinformation");
    }
}
