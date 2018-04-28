package com.example.thiti.project_application;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

// This class will be called from adapter
public class InformationActivity extends AppCompatActivity {

    TextView topic;
    ImageView image;
    TextView longDesc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);

        topic = findViewById(R.id.topic);
        image = findViewById(R.id.image);
        image.setAdjustViewBounds(true);
        longDesc = findViewById(R.id.longDesc);

        //Bundle will contain data from adapter, which is recieved from firebase
        Bundle bundle = getIntent().getExtras();

        if (bundle != null) {
            topic.setText(bundle.getString("topic"));
            longDesc.setText(bundle.getString("longDesc"));
            //Picasso library willl Convert path from internet 
            Picasso.get().load(bundle.getString("linkImg")).into(image);
        }
    }
}
