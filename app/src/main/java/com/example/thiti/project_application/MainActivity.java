package com.example.thiti.project_application;

import android.content.Context;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    private EditText gpax;
    private EditText thai;
    private EditText social;
    private EditText eng;
    private EditText math;
    private EditText science;
    private EditText gat;
    private EditText pat1;
    private EditText pat2;
    private Context mContext;
    private EditText solution;
    private Button calculate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getApplicationContext();
        setContentView(R.layout.activity_main);
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
                    double result = (new Double(gpax.getText().toString())*1500)+((new Double(thai.getText().toString()) + new Double(social.getText().toString())
                            + new Double(eng.getText().toString()) + new Double(math.getText().toString()) + new Double(social.getText().toString()))*18)
                            +(new Double(gat.getText().toString())*10) + (new Double(pat1.getText().toString())*20) + (new Double(pat2.getText().toString())*20);
                    solution.setText(Double.toString(result));

                }

            }
        });
    }
}


