package com.edu.android.ad0821e_mapa1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    //Khai bao
    Button btnLayout, btnEvent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Map
        btnLayout = (Button) findViewById(R.id.btnLayout);
        btnEvent = (Button) findViewById(R.id.btnEvent);

        btnLayout.setOnClickListener(this);
        btnEvent.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.btnLayout) {
            Intent intent = new Intent(MainActivity.this, LayoutActivity.class);
            startActivity(intent);
        } else if(view.getId() == R.id.btnEvent) {
            Intent intent = new Intent(MainActivity.this, EventActivity.class);
            startActivity(intent);
        }
    }
}