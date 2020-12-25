package com.example.hostelmanager;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class StudentDetails extends AppCompatActivity {
    TextView nameT, rollT, deptT, yearT;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_details);
        nameT = (TextView) findViewById(R.id.Name);
        rollT = (TextView) findViewById(R.id.RollNo);
        deptT = (TextView) findViewById(R.id.Dept);
        yearT = (TextView) findViewById(R.id.Year);
    }

    public void EditDetails(View view) {
        //open edit screen
        Intent intent = new Intent(this, EditDetailsActivity.class);
        startActivity(intent);
    }
}