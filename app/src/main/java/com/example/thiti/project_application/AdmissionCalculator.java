package com.example.thiti.project_application;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class AdmissionCalculator extends AppCompatActivity {
    public EditText gpax;       //Cumulative grade
    public EditText thai;       //o-net thai score
    public EditText social;     //o-net social score
    public EditText eng;        //o-net eng score
    public EditText math;       //o-net math score
    public EditText science;    //o-net science score
    public EditText gat;        //gat score
    public EditText pat1;       //pat1 score
    public EditText pat2;       //pat2 score
    public Context mContext;
    public EditText solution;   //total score
    public Button calculate;    //calculated button


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admission_calculator);

        //get the value from user's input
        mContext = getApplicationContext();
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

        //action after user input all of variables and click on the button
        calculate.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                //if user not fill in any scores, the application will alert the error message
                if ((thai.getText().length() == 0)
                        || (thai.getText().toString() == "")
                        || (gpax.getText().length() == 0)
                        || (gpax.getText().toString() == "")
                        || (social.getText().length() == 0)
                        || (social.getText().toString() == "")
                        || (eng.getText().length() == 0)
                        || (eng.getText().toString() == "")
                        || (math.getText().length() == 0)
                        || (math.getText().toString() == "")
                        || (science.getText().length() == 0)
                        || (science.getText().toString() == "")
                        || (gat.getText().length() == 0)
                        || (gat.getText().toString() == "")
                        || (pat1.getText().length() == 0)
                        || (pat1.getText().toString() == "")
                        || (pat2.getText().length() == 0)
                        || (pat2.getText().toString() == "")) {

                    //AlertDialog to popup the error message
                    AlertDialog alertDialog = new AlertDialog.Builder(AdmissionCalculator.this).create();
                    alertDialog.setTitle("Error");
                    alertDialog.setMessage("Some inputs are empty");
                    alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            });
                    alertDialog.show();

                } else if((new Double (gpax.getText().toString()) > 4)
                        ||(new Double (thai.getText().toString()) > 100)
                        ||(new Double (social.getText().toString()) > 100)
                        ||(new Double (eng.getText().toString()) > 100)
                        ||(new Double (math.getText().toString()) > 100)
                        ||(new Double (science.getText().toString()) > 100)
                        ||(new Double (gat.getText().toString()) > 300)
                        ||(new Double (pat1.getText().toString()) > 300)
                        ||(new Double (pat2.getText().toString()) > 300)){

                    //AlertDialog to popup the error message
                    AlertDialog alertDialog = new AlertDialog.Builder(AdmissionCalculator.this).create();
                    alertDialog.setTitle("Error");
                    alertDialog.setMessage("Some inputs are error");
                    alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            });
                    alertDialog.show();

                    }
                else {
                    //calculate the total score from user's input
                    double result = (new Double(gpax.getText().toString()) * 1500) + ((new Double(thai.getText().toString()) + new Double(social.getText().toString())
                            + new Double(eng.getText().toString()) + new Double(math.getText().toString()) + new Double(social.getText().toString())) * 18)
                            + (new Double(gat.getText().toString()) * 10) + (new Double(pat1.getText().toString()) * 20) + (new Double(pat2.getText().toString()) * 20);
                    solution.setText(Double.toString(result));

                    //popup the message when score is greater than 11000 (have a chance to become a part of MUICT)
                    if (result >= 11000) {
                        AlertDialog alertDialog = new AlertDialog.Builder(AdmissionCalculator.this).create();
                        alertDialog.setTitle("Well done!");
                        alertDialog.setMessage("You have a high chance to become a part of next MUICT.");
                        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.dismiss();
                                    }
                                });
                        alertDialog.show();

                    }
                    //popup the message when score is less than 11000 (too low score)
                    else {
                        AlertDialog alertDialog = new AlertDialog.Builder(AdmissionCalculator.this).create();
                        alertDialog.setTitle("Almost there...");
                        alertDialog.setMessage("You may need to practice more and achieve a higher score. Keep fighting!");
                        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.dismiss();
                                    }
                                });
                        alertDialog.show();


                    }
                }
            }

        });
    }
}