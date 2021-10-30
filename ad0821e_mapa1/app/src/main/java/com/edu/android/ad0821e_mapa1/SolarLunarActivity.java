package com.edu.android.ad0821e_mapa1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class SolarLunarActivity extends AppCompatActivity {
    EditText txtSolarYear;
    Button btnSwitch;
    Spinner spinner1, spinner2;
    //TextView txtResult;

    String diachi;


    ArrayAdapter<CharSequence> spinnerAdapter1, spinnerAdapter2;
    String dsThienCanDuong = "Giáp, Bính, Mậu, Canh, Nhâm";
    String dsThienCanAm = "Ất, Đinh, Kỷ, Tân, Quý";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solar_lunar);

        //txtResult = (TextView) findViewById(R.id.txtResult);
        txtSolarYear = (EditText) findViewById(R.id.txtSolarYear);
        btnSwitch = (Button) findViewById(R.id.btnSwitch);
        spinner1 = (Spinner) findViewById(R.id.spinner1);//Thiên Can: Canh Tân, Nhâm...10 thiên can
        spinner2 = (Spinner) findViewById(R.id.spinner2);//Địa Chi: Tý Sửu Dần Mão...12 con giáp
        //Load data to spinner
        loadSpinner1();
        loadSpinner2(R.array.DiaChiDuong);

        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                String thienCan = spinnerAdapter1.getItem(position).toString();
                if(dsThienCanDuong.indexOf(thienCan) > -1) {
                    loadSpinner2(R.array.DiaChiDuong);
                } else if(dsThienCanAm.indexOf(thienCan) > -1) {
                    loadSpinner2(R.array.DiaChiAm);
                }spinner2.setSelection(spinnerAdapter2.getPosition(diachi));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        btnSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Lấy năm DL/ÂL
                String solarYear = txtSolarYear.getText().toString();
                if(solarYear.equals("")){//không nhập năm DL
                    //AL -> DL
                    int indexTC = spinner1.getSelectedItemPosition();
                    int indexDC = spinner2.getSelectedItemPosition();
                    for(int i=2021;i>1982;i--){
                        if((i%10)==indexTC && (i%12) == indexDC){
                            txtSolarYear.setText(String.valueOf(i));
                            break;
                        }
                    }

                }else{
                    //DL-AL
                    short sSolarYear = Short.parseShort(solarYear);
                    int idxThienCan = new SolarLunarActivity().getThienCan(sSolarYear);
                     diachi = new SolarLunarActivity().getDiaChi(sSolarYear);

                    spinner1.setSelection(idxThienCan);
                    //Vo nghia vi bi chen ngang
                }// Lớp và thành phần lớp: MethodA -> MethodB của chính class

            }
        });
    }

    private void loadSpinner2(int loaiDiaChi) {
        spinnerAdapter2 = ArrayAdapter.createFromResource(this, loaiDiaChi, R.layout.spinner_textview);
        spinnerAdapter2.setDropDownViewResource(R.layout.spinner_textview);
        spinner2.setAdapter(spinnerAdapter2);
    }

    private void loadSpinner1() {
        spinnerAdapter1 = ArrayAdapter.createFromResource(this, R.array.ThienCan, R.layout.spinner_textview);
        spinnerAdapter1.setDropDownViewResource(R.layout.spinner_textview);
        spinner1.setAdapter(spinnerAdapter1);
    }

    private  int getThienCan(short solarYear){
        return solarYear %10;
    }



    protected String getThienCan1(short solarYear) {
        String can = "";
        switch (solarYear % 10) {
            case 0:
                can = "Canh";
                break;
            case 1:
                can = "Tân";
                break;
            case 2:
                can = "Nhâm";
                break;
            case 3:
                can = "Quý";
                break;
            case 4:
                can = "Giáp";
                break;
            case 5:
                can = "Ất";
                break;
            case 6:
                can = "Bính";
                break;
            case 7:
                can = "Đinh";
                break;
            case 8:
                can = "Mậu";
                break;
            case 9:
                can = "Kỷ";
                break;
        }
        return can;
    }
    private String getDiaChi(short solarYear) {
        // Xác định Chi
        String chi = "";
        switch (solarYear % 12) {
            case 0:
                chi = "Thân";
                break;
            case 1:
                chi = "Dậu";
                break;
            case 2:
                chi = "Tuất";
                break;
            case 3:
                chi = "Hợi";
                break;
            case 4:
                chi = "Tý";
                break;
            case 5:
                chi = "Sửu";
                break;
            case 6:
                chi = "Dần";
                break;
            case 7:
                chi = "Mão";
                break;
            case 8:
                chi = "Thìn";
                break;
            case 9:
                chi = "Tỵ";
                break;
            case 10:
                chi = "Ngọ";
                break;
            case 11:
                chi = "Mùi";
                break;
        }
        return chi;
    }
}