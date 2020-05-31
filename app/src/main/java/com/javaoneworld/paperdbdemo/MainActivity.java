package com.javaoneworld.paperdbdemo;

import androidx.appcompat.app.AppCompatActivity;
import io.paperdb.Paper;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.javaoneworld.paperdbdemo.model_classes.Student;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private EditText edtName, edtEmail;
    private Button btnSaveRecord, btnGetRecord;

    List<Student> studentList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtName = findViewById(R.id.edtName);
        edtEmail = findViewById(R.id.edtEmail);
        btnSaveRecord = findViewById(R.id.btnSave);
        btnGetRecord = findViewById(R.id.btnGetRecord);

        btnSaveRecord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(!edtName.getText().toString().trim().isEmpty() && !edtEmail.getText().toString().trim().isEmpty()){
                    Paper.book().write("student",new Student(edtName.getText().toString().trim(),edtEmail.getText().toString().trim()));
                }else {
                    Student student;
                    student = new Student("javaoneworld",
                            "Javaoneworld@gmail.com");
                    Paper.book().write("student",student);
                }
            }
        });

        btnGetRecord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                studentList = Paper.book().read("student");
                //use this list as you want

            }
        });
    }

    //delete data for one key
    //Paper.book().delete("contacts");

    //delete all key from the given book
    //Paper.book.destroy

    //get all keys
    //List<String> allKeys = Paper.book().getAllKeys();
}
