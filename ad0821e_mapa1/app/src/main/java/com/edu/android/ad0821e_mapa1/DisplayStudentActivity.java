package com.edu.android.ad0821e_mapa1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class DisplayStudentActivity extends AppCompatActivity {

    TextView txtFullName, txtSex;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_student);

        txtFullName = (TextView) findViewById(R.id.txtFullName);
        txtSex = (TextView) findViewById(R.id.txtSex);
        //Nhận cách 1
        Intent intent = getIntent();
        String fullName = intent.getStringExtra("FullName");
        String sex = intent.getStringExtra("Sex");
        txtFullName.setText(fullName);
        txtSex.setText(sex);

        //Nhận cách 2
        Bundle bundle = intent.getBundleExtra("Bundle");
        Student student = bundle.getParcelable("Student");
        txtFullName.setText(student.getName());
        txtSex.setText(student.getSex());

        //Luu tru doi tuong vao file
        //Storage: File,Shared Preference, Sqlite(CSDL)
    }
}