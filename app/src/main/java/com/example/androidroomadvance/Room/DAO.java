package com.example.androidroomadvance.Room;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

/**That class call DAO (Data access object), here we make functionality for insert,update,delete (query) ***/

@Dao
public interface DAO {

    @Insert
    public void studentInsertion(Student student);

    @Query("Select * from Student")
    List<Student> getStudent();


    @Query("Update Student set stuFirstName=:stuName where stuId=:stuId")
    void updateStudent(String stuName, int stuId);

    @Query("Delete from Student where stuId = :stuID")
    void deleteStu(int stuID);


}
