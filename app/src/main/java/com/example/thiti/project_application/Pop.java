package com.example.thiti.project_application;

import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.EditText;

/**
 * Created by Boonp on 27-Apr-18.
 */

class Pop extends AdmissionCalculator{
    private EditText score;
    private EditText text;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        double result = (new Double(gpax.getText().toString())*1500)+((new Double(thai.getText().toString()) + new Double(social.getText().toString())
                + new Double(eng.getText().toString()) + new Double(math.getText().toString()) + new Double(social.getText().toString()))*18)
                +(new Double(gat.getText().toString())*10) + (new Double(pat1.getText().toString())*20) + (new Double(pat2.getText().toString())*20);
        score.setText(Double.toString(result));
        setContentView(R.layout.popup_calculator);
        score = (EditText) findViewById(R.id.editText2);
        DisplayMetrics display = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(display);

        int width = display.widthPixels;
        int height = display.heightPixels;
    }
}
