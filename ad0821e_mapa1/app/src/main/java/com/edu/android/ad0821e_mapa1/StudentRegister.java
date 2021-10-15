package com.edu.android.ad0821e_mapa1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class StudentRegister extends AppCompatActivity {
    EditText edFullName;
    CheckBox football, travel, film;
    Spinner spinnerProvine;
    RadioButton male, female;
    ImageButton btnimg;
    DatePicker dtpDateofBirth;
    ArrayAdapter<CharSequence> spinnerAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_register);
        edFullName = (EditText) findViewById(R.id.edFullName);
        football = (CheckBox) findViewById(R.id.football);
        travel = (CheckBox) findViewById(R.id.travel);
        film = (CheckBox) findViewById(R.id.film);
        male = (RadioButton) findViewById(R.id.radioButtonMale);
        female = (RadioButton) findViewById(R.id.radioButtonFemale);
        spinnerProvine = (Spinner) findViewById(R.id.spinnerProvine);
        btnimg = (ImageButton) findViewById(R.id.imgbtn);
        dtpDateofBirth = (DatePicker) findViewById(R.id.dtpDateofBirth);
        loadspinner();
        addBirthDay();
        addFullName();
        addSex();
        addProvines();
        addHobbies();
    }

    private void addHobbies() {
        List<String> arrList = new ArrayList<>();
        if(football.isChecked()){
            arrList.add(football.getText().toString());
        }
        if(travel.isChecked()){
            arrList.add(travel.getText().toString());
        }
        if(film.isChecked()){
            arrList.add(film.getText().toString());
        }
    }

    private void addProvines() {
        String Provines = spinnerProvine.getSelectedItem().toString();
    }

    private void addSex() {
    }

    private void addFullName() {
        String FullName = edFullName.toString();
    }

    private void addBirthDay() {
        int date = dtpDateofBirth.getDayOfMonth();
        int month = dtpDateofBirth.getMonth();
        int year = dtpDateofBirth.getYear();
    }

    private void loadspinner() {
        spinnerAdapter = ArrayAdapter.createFromResource(this, R.array.TinhThanh, R.layout.spinner_textview);
        spinnerAdapter.setDropDownViewResource(R.layout.spinner_textview);
        spinnerProvine.setAdapter(spinnerAdapter);
    }
}