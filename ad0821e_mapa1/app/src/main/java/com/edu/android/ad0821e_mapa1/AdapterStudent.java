package com.edu.android.ad0821e_mapa1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.Spinner;

import androidx.annotation.NonNull;

import java.util.List;

public class AdapterStudent extends ArrayAdapter<StudentEntity> {
    private Context context;
    private int IdLayout;
    private List<StudentEntity> listStudent;

    public AdapterStudent(Context context, int resource,
                          List<StudentEntity> listStudent) {
        super(context, resource, listStudent);
        this.context = context;
        this.IdLayout = resource;
        this.listStudent = listStudent;
    }

    @Override
    public View getViews(int position, View convertView, ViewGroup parent) {
        View itemView = convertView;
        ViewHolder viewHolder = new ViewHolder();
        if (itemView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            itemView = inflater.inflate(IdLayout, null);
        //gọi đến các thành phần giao diện
            viewHolder.edName = (EditText) itemView.findViewById(R.id.edFullName);
            viewHolder.dtpDateofBirth = (DatePicker) itemView.findViewById(R.id.dtpDateofBirth);
            viewHolder.radioButtonMale = (RadioButton) itemView.findViewById(R.id.radioButtonMale);
            viewHolder.radioButtonFemale = (RadioButton) itemView.findViewById(R.id.radioButtonFemale);
            viewHolder.spinnerProvine = (Spinner) itemView.findViewById(R.id.spinnerProvine);
            viewHolder.travel = (CheckBox) itemView.findViewById(R.id.travel);
            viewHolder.football = (CheckBox) itemView.findViewById(R.id.football);
            viewHolder.film = (CheckBox) itemView.findViewById(R.id.film);
            viewHolder.seekbar = (SeekBar) itemView.findViewById(R.id.seekbar);
            viewHolder.rating = (RatingBar) itemView.findViewById(R.id.rating);
            itemView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) itemView.getTag();
        }
        //truyền giá trị
        viewHolder.edName.setText(listStudent.get(position).getEdName());
        viewHolder.dtpDateofBirth.
        viewHolder.radioButtonMale.setClickable(listStudent.get(position).getRadioButtonMale());
        return itemView;
    }

    public class ViewHolder {
        EditText edName;
        DatePicker dtpDateofBirth;
        RadioButton radioButtonMale;
        RadioButton radioButtonFemale;
        Spinner spinnerProvine;
        CheckBox travel;
        CheckBox football;
        CheckBox film;
        SeekBar seekbar;
        RatingBar rating;
    }
}
