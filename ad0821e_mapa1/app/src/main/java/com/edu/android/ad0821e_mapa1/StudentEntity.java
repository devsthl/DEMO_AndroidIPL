package com.edu.android.ad0821e_mapa1;

import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.RadioButton;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.Spinner;

public class StudentEntity {
    private String fullName;
    private String dtpDateofBirth;
    private RadioButton radioButtonMale;
    private RadioButton radioButtonFemale;
    private Spinner spinnerProvine;
    private CheckBox travel;
    private CheckBox football;
    private CheckBox film;
    private SeekBar seekbar;
    private RatingBar rating;

    public StudentEntity(String edName, DatePicker dtpDateofBirth, RadioButton radioButtonMale, RadioButton radioButtonFemale, Spinner spinnerProvine, CheckBox travel, CheckBox football, CheckBox film, SeekBar seekbar, RatingBar rating) {
        this.edName = edName;
        this.dtpDateofBirth = dtpDateofBirth;
        this.radioButtonMale = radioButtonMale;
        this.radioButtonFemale = radioButtonFemale;
        this.spinnerProvine = spinnerProvine;
        this.travel = travel;
        this.football = football;
        this.film = film;
        this.seekbar = seekbar;
        this.rating = rating;
    }

    public String getEdName() {
        return edName;
    }

    public void setEdName(String edName) {
        this.edName = edName;
    }

    public DatePicker getDtpDateofBirth() {
        return dtpDateofBirth;
    }

    public void setDtpDateofBirth(DatePicker dtpDateofBirth) {
        this.dtpDateofBirth = dtpDateofBirth;
    }

    public RadioButton getRadioButtonMale() {
        return radioButtonMale;
    }

    public void setRadioButtonMale(RadioButton radioButtonMale) {
        this.radioButtonMale = radioButtonMale;
    }

    public RadioButton getRadioButtonFemale() {
        return radioButtonFemale;
    }

    public void setRadioButtonFemale(RadioButton radioButtonFemale) {
        this.radioButtonFemale = radioButtonFemale;
    }

    public Spinner getSpinnerProvine() {
        return spinnerProvine;
    }

    public void setSpinnerProvine(Spinner spinnerProvine) {
        this.spinnerProvine = spinnerProvine;
    }

    public CheckBox getTravel() {
        return travel;
    }

    public void setTravel(CheckBox travel) {
        this.travel = travel;
    }

    public CheckBox getFootball() {
        return football;
    }

    public void setFootball(CheckBox football) {
        this.football = football;
    }

    public CheckBox getFilm() {
        return film;
    }

    public void setFilm(CheckBox film) {
        this.film = film;
    }

    public SeekBar getSeekbar() {
        return seekbar;
    }

    public void setSeekbar(SeekBar seekbar) {
        this.seekbar = seekbar;
    }

    public RatingBar getRating() {
        return rating;
    }

    public void setRating(RatingBar rating) {
        this.rating = rating;
    }
}
