package com.example.hostelmanager;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class StaffDetails extends AppCompatActivity {

    TextView nameT, rollT, deptT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staff_details);

        nameT = (TextView) findViewById(R.id.Name);
        rollT = (TextView) findViewById(R.id.RollNo);
        deptT = (TextView) findViewById(R.id.Dept);
    }

    public void EditDetails(View view) {
        //open edit screen
    }
}