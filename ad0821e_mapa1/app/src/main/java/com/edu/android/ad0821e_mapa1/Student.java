package com.edu.android.ad0821e_mapa1;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

public class Student implements Parcelable {
    private String name;
    private String date;
    private String sex;
    private String province;
    private List<String> hobby;
    private float level;
    private float rating;

    public Student(String name, String date, String sex, String province, List<String> hobby, float level, float rating) {
        this.name = name;
        this.date = date;
        this.sex = sex;
        this.province = province;
        this.hobby = hobby;
        this.level = level;
        this.rating = rating;
    }

    public Student() {

    }

    protected Student(Parcel in) {
        name = in.readString();
        date = in.readString();
        sex = in.readString();
        province = in.readString();
        hobby = in.createStringArrayList();
        level = in.readFloat();
        rating = in.readFloat();
    }

    public static final Creator<Student> CREATOR = new Creator<Student>() {
        @Override
        public Student createFromParcel(Parcel in) {
            return new Student(in);
        }

        @Override
        public Student[] newArray(int size) {
            return new Student[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public List<String> getHobby() {
        return hobby;
    }

    public void setHobby(List<String> hobby) {
        this.hobby = hobby;
    }

    public float getLevel() {
        return level;
    }

    public void setLevel(float level) {
        this.level = level;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(date);
        dest.writeString(sex);
        dest.writeString(province);
        dest.writeStringList(hobby);
        dest.writeFloat(level);
        dest.writeFloat(rating);
    }
}
