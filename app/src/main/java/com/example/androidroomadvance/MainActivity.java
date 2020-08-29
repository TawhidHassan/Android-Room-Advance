package com.example.androidroomadvance;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.androidroomadvance.Room.DatabaseClient;
import com.example.androidroomadvance.Room.MyDatabase;
import com.example.androidroomadvance.Room.Table.Course;
import com.example.androidroomadvance.Room.Table.Student;
import com.example.androidroomadvance.Room.Table.StudentDeatils;
import com.example.androidroomadvance.Room.Table.StudentWithDetails;

import java.util.Calendar;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    EditText firstName , secondName, className , address , phone,courseNmae ;
    Button insert , read , insertDetails,courseInsert;
    MyDatabase myDatabase;
    long stuId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstName = (EditText) findViewById(R.id.firstName);
        secondName = (EditText) findViewById(R.id.secondName);
        className = (EditText) findViewById(R.id.className);
        address = (EditText) findViewById(R.id.address);
        phone = (EditText) findViewById(R.id.phone);
        courseNmae = (EditText) findViewById(R.id.course);
        courseInsert = (Button) findViewById(R.id.coursebtn);
        insert = (Button) findViewById(R.id.insert);
        read = (Button) findViewById(R.id.readx);
        insertDetails = (Button) findViewById(R.id.details);
        setUpDB();


        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Student student=new Student(firstName.getText().toString(),secondName.getText().toString(),className.getText().toString(), Calendar.getInstance().getTime());
               stuId=  myDatabase.dao().studentInsertion(student);
            }
        });

        read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                List<Student> stuData= myDatabase.dao().getStudent();
                List<StudentWithDetails> studentDeatils= myDatabase.dao().getData();

                for (int i=0; i<studentDeatils.size();i++){

                    Toast.makeText(MainActivity.this,stuData.get(i).getStuId() +") "+ stuData.get(i).getStuFirstName() +"-> "+stuData.get(i).getStuClass() +" date: "+stuData.get(i).getDate(), Toast.LENGTH_SHORT).show();

                    for (int j=0; j<studentDeatils.get(i).getStudentDeatils().size(); j++){
                        Toast.makeText(MainActivity.this, "Home:"+studentDeatils.get(i).getStudentDeatils().get(j).getHomeAddress()+"\nphone:"+studentDeatils.get(i).getStudentDeatils().get(j).getPhoneNumber(), Toast.LENGTH_SHORT).show();
                    }
                }


            }
        });

        insertDetails.setOnClickListener(new View.OnClickListener() {//use it for one to one relationship
            @Override
            public void onClick(View view) {

                StudentDeatils studentDeatils=new StudentDeatils((int) stuId,address.getText().toString(),phone.getText().toString());

                myDatabase.dao().studentDetailsInsertion(studentDeatils);


            }
        });

        courseInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Course course=new Course(courseNmae.getText().toString());
                myDatabase.dao().corseInsertion(course);
            }
        });


    }

    private void setUpDB(){
        myDatabase= DatabaseClient.databaseClient(this);
    }
}
