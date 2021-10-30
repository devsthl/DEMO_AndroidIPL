package com.edu.android.ad0821e_mapa1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class EventActivity extends AppCompatActivity implements View.OnClickListener{
    Button btnSolarLunar, btnStudent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);

        btnSolarLunar = (Button) findViewById(R.id.btnSolarLunar);
        btnStudent = (Button) findViewById(R.id.btnStudent);
        btnSolarLunar.setOnClickListener(this);
        btnStudent.setOnClickListener(this);


    }



    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.btnSolarLunar) {
            Intent intent = new Intent(EventActivity.this, SolarLunarActivity.class);
            startActivity(intent);
        }else if(view.getId() == R.id.btnStudent){
            Intent intent = new Intent(EventActivity.this, StudentRegisterActivity.class);
            startActivity(intent);
        }
    }
}