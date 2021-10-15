package com.edu.android.ad0821e_mapa1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class LayoutActivity extends AppCompatActivity implements View.OnClickListener{
    Button btnLinenear, btnGrid, btnTable, btnFrame, btnConstraint;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout);

        btnLinenear = (Button) findViewById(R.id.btnLinenear);
        btnGrid = (Button) findViewById(R.id.btnGrid);
        btnTable = (Button) findViewById(R.id.btnTable);
        btnFrame = (Button) findViewById(R.id.btnFrame);
        btnConstraint = (Button) findViewById(R.id.btnConstraint);
        btnLinenear.setOnClickListener(this);
        btnGrid.setOnClickListener(this);
        btnTable.setOnClickListener(this);
        btnFrame.setOnClickListener(this);
        btnConstraint.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.btnLinenear) {
            Intent intent = new Intent(LayoutActivity.this, LinenearActivity.class);
            startActivity(intent);
        } else if(view.getId() == R.id.btnGrid) {

        } else if(view.getId() == R.id.btnTable) {
            Intent intent = new Intent(LayoutActivity.this, TableLayout.class);
            startActivity(intent);
        } else if(view.getId() == R.id.btnFrame) {
            Intent intent = new Intent(LayoutActivity.this, FrameLayoutDemo.class);
            startActivity(intent);
        } else if(view.getId() == R.id.btnConstraint) {
            Intent intent = new Intent(LayoutActivity.this, ConstraintLayoutActivity.class);
            startActivity(intent);
        }
    }
}
