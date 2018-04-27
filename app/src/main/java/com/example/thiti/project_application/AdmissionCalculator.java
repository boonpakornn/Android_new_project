package com.example.thiti.project_application;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class AdmissionCalculator extends AppCompatActivity {
    public EditText gpax;
    public EditText thai;
    public EditText social;
    public EditText eng;
    public EditText math;
    public EditText science;
    public EditText gat;
    public EditText pat1;
    public EditText pat2;
    public Context mContext;
    public EditText solution;
    public Button calculate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getApplicationContext();
        setContentView(R.layout.activity_admission_calculator);
        gpax = (EditText) findViewById(R.id.editText2);
        thai = (EditText) findViewById(R.id.editText4);
        social = (EditText) findViewById(R.id.editText5);
        eng = (EditText) findViewById(R.id.editText7);
        math = (EditText) findViewById(R.id.editText8);
        science = (EditText) findViewById(R.id.editText9);
        gat = (EditText) findViewById(R.id.editText10);
        pat1 = (EditText) findViewById(R.id.editText11);
        pat2 = (EditText) findViewById(R.id.editText12);
        solution = (EditText) findViewById(R.id.editText);
        Button calculate = (Button) findViewById(R.id.button);

        calculate.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0){
                if ((thai.getText().length() == 0)
                        || (thai.getText().toString() == "")
                        || (gpax.getText().length() == 0)
                        || (gpax.getText().toString() == "")
                        || (social.getText().length() == 0)
                        || (social.getText().toString() == "")
                        || (eng.getText().length() == 0)
                        || (math.getText().toString() == "")
                        || (science.getText().length() == 0)
                        || (science.getText().toString() == "")
                        || (gat.getText().length() == 0)
                        || (gat.getText().toString() == "")
                        || (pat1.getText().length() == 0)
                        || (pat1.getText().toString() == "")
                        || (pat2.getText().length() == 0)
                        || (pat2.getText().toString() == "")) {
                    new AlertDialog.Builder(mContext).setTitle("Error")
                            .setMessage("Some inputs are empty")
                            .setPositiveButton("OK", null).show();
                }
                else {
                    startActivity(new Intent(AdmissionCalculator.this,Pop.class));
                }
            }

        });
    }
}


