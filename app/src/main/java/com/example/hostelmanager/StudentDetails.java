package com.example.hostelmanager;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class StudentDetails extends AppCompatActivity {
    SharedPreferences prefs;
    TextView nameT, rollT, deptT, yearT, inTimeT;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_details);
        nameT = (TextView) findViewById(R.id.Name);
        rollT = (TextView) findViewById(R.id.RollNo);
        deptT = (TextView) findViewById(R.id.Dept);
        yearT = (TextView) findViewById(R.id.Year);
        inTimeT = (TextView) findViewById(R.id.inTime);
        prefs = this.getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        String Name = prefs.getString("Snname", "Student 1");
        String Id = prefs.getString("Snroll", "1");
        String Dept = prefs.getString("Sndept", "CSE");
        String Year = prefs.getString("Snyear", "1");
        String InTime = prefs.getString("SninTime", "8:00 AM");

        nameT.setText(Name);
        rollT.setText(Id);
        deptT.setText(Dept);
        yearT.setText(Year);
        inTimeT.setText(InTime);
    }

    public void EditDetails(View view) {
        //open edit screen
        Intent intent = new Intent(this, EditDetailsActivity.class);
        startActivity(intent);
    }
}