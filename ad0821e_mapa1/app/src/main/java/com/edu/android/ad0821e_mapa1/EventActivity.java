package com.edu.android.ad0821e_mapa1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class EventActivity extends AppCompatActivity implements View.OnClickListener{
    Button btnSolarLunar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);

        btnSolarLunar = (Button) findViewById(R.id.btnSolarLunar);
        btnSolarLunar.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.btnSolarLunar) {
            Intent intent = new Intent(EventActivity.this, SolarLunarActivity.class);
            startActivity(intent);
        }
    }
}