package com.example.androidroomadvance.Room;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.androidroomadvance.Room.Table.Course;
import com.example.androidroomadvance.Room.Table.Student;
import com.example.androidroomadvance.Room.Table.StudentDeatils;

/**That class call DAtabase, here we make datase here all main work will perform like inser delete update all work perform here ***/



@Database(entities = {Student.class, StudentDeatils.class, Course.class},version = 1,exportSchema = false)
public abstract class MyDatabase extends RoomDatabase {

    public abstract DAO dao();

}
