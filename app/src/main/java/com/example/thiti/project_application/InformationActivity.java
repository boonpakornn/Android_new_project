package com.example.thiti.project_application;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

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

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            topic.setText(bundle.getString("topic"));
            longDesc.setText(bundle.getString("longDesc"));
            Picasso.get().load(bundle.getString("linkImg")).into(image);
        }
    }
}
