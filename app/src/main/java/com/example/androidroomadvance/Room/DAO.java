package com.example.androidroomadvance.Room;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.androidroomadvance.Room.Table.Student;
import com.example.androidroomadvance.Room.Table.StudentDeatils;
import com.example.androidroomadvance.Room.Table.StudentWithDetails;

import java.util.List;

/**That class call DAO (Data access object), here we make functionality for insert,update,delete (query) ***/

@Dao
public interface DAO {

    @Insert
    public long studentInsertion(Student student);

    @Insert
    public void studentDetailsInsertion(StudentDeatils studentDeatils); //for relation ship table

    @Query("Select * from Student")
    public StudentWithDetails getData();

    @Query("Select * from Student")
    List<Student> getStudent();


    @Query("Update Student set stuFirstName=:stuName where stuId=:stuId")
    void updateStudent(String stuName, int stuId);

    @Query("Delete from Student where stuId = :stuID")
    void deleteStu(int stuID);


}
