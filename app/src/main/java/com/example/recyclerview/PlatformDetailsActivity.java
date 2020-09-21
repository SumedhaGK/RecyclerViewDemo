package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class PlatformDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_platform_details);

        TextView platformDetails = (TextView) findViewById(R.id.platformDetailsText);
        String stringPlatformDetails = getIntent().getStringExtra("platformDetails");
        platformDetails.setText(stringPlatformDetails);
    }
}