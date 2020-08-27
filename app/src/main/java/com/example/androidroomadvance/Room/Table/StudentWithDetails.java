package com.example.androidroomadvance.Room.Table;

import androidx.room.Embedded;
import androidx.room.Relation;

import java.util.List;

public class StudentWithDetails {

    @Embedded
    Student student;

    @Relation(parentColumn = "stuId",entityColumn = "stuId",entity = StudentDeatils.class)
    public List<StudentDeatils> studentDeatils;

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public List<StudentDeatils> getStudentDeatils() {
        return studentDeatils;
    }

    public void setStudentDeatils(List<StudentDeatils> studentDeatils) {
        this.studentDeatils = studentDeatils;
    }
}
