package com.edu.android.ad0821e_mapa1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StudentRegisterActivity extends AppCompatActivity {
    Student st = new Student();

    ConstraintLayout csStudent;
    Spinner spinnerProvince;
    EditText edtFullName;
    DatePicker dtpDateofBirth;
    RadioGroup radioGroupSex;
    RadioButton rbtnMale, rbtnFemale;
    CheckBox chkHobbyFootball, chkHobbyBadminton, chkHobbyFilm;
    ImageButton btnRegister;
    SeekBar sbTrinhdo;
    RatingBar rbRating;
    

    ArrayAdapter<CharSequence> spinnerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_register);

        csStudent = (ConstraintLayout) findViewById(R.id.csStudent);
        spinnerProvince = (Spinner) findViewById(R.id.spinnerProvince);
        edtFullName = (EditText) findViewById(R.id.edtFullName);
        dtpDateofBirth = (DatePicker) findViewById(R.id.dtpDateofBirth);
        radioGroupSex = (RadioGroup) findViewById(R.id.radioGroupSex);

        chkHobbyFootball = (CheckBox) findViewById(R.id.chkHobbyFootball);
        chkHobbyBadminton = (CheckBox) findViewById(R.id.chkHobbyBadminton);
        chkHobbyFilm = (CheckBox) findViewById(R.id.chkHobbyFilm);
        btnRegister = (ImageButton) findViewById(R.id.btnRegister);
        sbTrinhdo = (SeekBar) findViewById(R.id.sbTrinhDo);
        rbRating = (RatingBar) findViewById(R.id.rbRating);


        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //l???y t??n
                String fullName = edtFullName.getText().toString();
                st.setName(fullName);


                //L???y ng??y sinh
                int date = dtpDateofBirth.getDayOfMonth();
                int month = dtpDateofBirth.getMonth();
                int year = dtpDateofBirth.getYear();
                String x = String.valueOf(date) + "/" + String.valueOf(month) + "/" +String.valueOf(year);
                st.setDate(x);

                //l???y gi???i t??nh
                //boolean isMale = rbtnMale.isChecked()? true:false;
                //String sex = rbtnMale.isChecked()? "Male" : "Female"
                String valueGender = ((RadioButton)findViewById(radioGroupSex.getCheckedRadioButtonId())).getText().toString();

                //l???y t???nh th??nh
                String txtProvince = spinnerProvince.getSelectedItem().toString();
                st.setProvince(txtProvince);

                //l???y s??? th??ch
                List<String> arrList = new ArrayList<>();
                 if(chkHobbyFootball.isChecked()){
                    arrList.add(chkHobbyFootball.getText().toString());
                }
                if(chkHobbyBadminton.isChecked()){
                    arrList.add(chkHobbyBadminton.getText().toString());
                }
                if(chkHobbyFilm.isChecked()){
                    arrList.add(chkHobbyFilm.getText().toString());
                }
                st.setHobby(arrList);

                //L???y tr??nh ?????
                int seekBar = sbTrinhdo.getProgress();
                st.setLevel(seekBar);

                //L???y rating
                int star = rbRating.getNumStars();
                float getrating = rbRating.getRating();
                //String rate = "Rating: " + getrating + "/" + star;
                st.setRating(getrating);

                //Truy???n d??? li???u

                //c??ch 1
                Intent intent = new Intent(StudentRegisterActivity.this,DisplayStudentActivity.class);
                intent.putExtra("FullName",fullName);
                intent.putExtra("DateofBirth",x);
                intent.putExtra("Sex",valueGender);
                intent.putExtra("Province",txtProvince);
                //intent.putExtra("Hobby",arrList); ch?? ??
                intent.putExtra("Level",seekBar);
                intent.putExtra("Rating", getrating);
                startActivity(intent);

                //C??ch 1.1:
                Bundle bundle = new Bundle();
                bundle.putString("FullName",fullName);
                bundle.putFloat("Satisfy",getrating);
                intent.putExtra("Bundle",bundle);
                startActivity(intent);

                //C??ch 2:
                bundle.putParcelable("Student",st);
                intent.putExtra("Bundle",bundle);
                startActivity(intent);

                //L??u tr??? d??? li???u: storage
                //Shared Preference
                saveSharedPreference(st);
            }


        });

        loadSpinner();


//        csStudent.setBackgroundResource(R.drawable.background1);
    }

    private void loadSpinner() {
        spinnerAdapter = ArrayAdapter.createFromResource(this, R.array.province, R.layout.spinner_textview);
        spinnerAdapter.setDropDownViewResource(R.layout.spinner_textview);
        spinnerProvince.setAdapter(spinnerAdapter);
    }
    private void saveSharedPreference(Student student) {
        SharedPreferences sharedPreferences = this.getSharedPreferences("student", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("FullName",student.getName());
        editor.putString("Sex",student.getSex());
        editor.commit();
        editor.apply();
    }
    //?????c d??? li???u t??? SharePre g??n v??o view
    void getInfoStudent(){
        SharedPreferences sharedPreferences = this.getSharedPreferences("student", Context.MODE_PRIVATE);
        if(sharedPreferences!=null){
            String fullName= sharedPreferences.getString("FullName","FullName");
            String sex= sharedPreferences.getString("Sex","Sex");
            edtFullName.setText(fullName);
        }
    }
}