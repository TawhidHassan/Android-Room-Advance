package com.example.androidroomadvance.Room.Table;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverter;
import androidx.room.TypeConverters;

import com.example.androidroomadvance.Room.DateTypeConvertor;

import java.util.Date;

/**That class call entity, here we make table ***/

@Entity
public class Student {

    @PrimaryKey(autoGenerate = true)
    int stuId;

    String stuFirstName;
    String stuLastName;
    String stuClass;

    @TypeConverters({DateTypeConvertor.class})
    Date date;

    public Student(String stuFirstName, String stuLastName, String stuClass,Date date) {
        this.stuFirstName = stuFirstName;
        this.stuLastName = stuLastName;
        this.stuClass = stuClass;
        this.date = date;
    }

    public int getStuId() {
        return stuId;
    }

    public void setStuId(int stuId) {
        this.stuId = stuId;
    }

    public String getStuFirstName() {
        return stuFirstName;
    }

    public void setStuFirstName(String stuFirstName) {
        this.stuFirstName = stuFirstName;
    }

    public String getStuLastName() {
        return stuLastName;
    }

    public void setStuLastName(String stuLastName) {
        this.stuLastName = stuLastName;
    }

    public String getStuClass() {
        return stuClass;
    }

    public void setStuClass(String stuClass) {
        this.stuClass = stuClass;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
