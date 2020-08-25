package com.example.androidroomadvance;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Database;
import androidx.room.Room;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.androidroomadvance.Room.DatabaseClient;
import com.example.androidroomadvance.Room.MyDatabase;
import com.example.androidroomadvance.Room.Student;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    EditText firstName , secondName, className , updatename , updateid , deleteID;
    Button insert , read , btnUpdate , btnDelete;
    MyDatabase myDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstName = (EditText) findViewById(R.id.firstName);
        secondName = (EditText) findViewById(R.id.secondName);
        className = (EditText) findViewById(R.id.className);
        updatename = (EditText) findViewById(R.id.updatename);
        updateid = (EditText) findViewById(R.id.updateid);
        deleteID = (EditText) findViewById(R.id.deleteID);
        insert = (Button) findViewById(R.id.insert);
        read = (Button) findViewById(R.id.read);
        btnUpdate = (Button) findViewById(R.id.btnUpdate);
        btnDelete = (Button) findViewById(R.id.btnDelete);
        setUpDB();


        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Student student=new Student(firstName.getText().toString(),secondName.getText().toString(),className.getText().toString());

                myDatabase.dao().studentInsertion(student);
            }
        });

        read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                List<Student> stuData= myDatabase.dao().getStudent();

                for (int i=0; i<stuData.size();i++){

                    Toast.makeText(MainActivity.this,stuData.get(i).getStuId() +") "+ stuData.get(i).getStuFirstName() +"-> "+stuData.get(i).getStuClass() , Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myDatabase.dao().updateStudent(updatename.getText().toString() , Integer.parseInt(updateid.getText().toString()));
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                myDatabase.dao().deleteStu(Integer.parseInt(deleteID.getText().toString()));
            }
        });



    }

    private void setUpDB(){
        myDatabase= DatabaseClient.databaseClient(this);
    }
}
