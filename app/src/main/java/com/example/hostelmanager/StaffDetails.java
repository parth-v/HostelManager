package com.example.hostelmanager;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class StaffDetails extends AppCompatActivity {
    SharedPreferences prefs;
    TextView nameT, rollT, deptT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staff_details);

        nameT = (TextView) findViewById(R.id.Name);
        rollT = (TextView) findViewById(R.id.RollNo);
        deptT = (TextView) findViewById(R.id.Dept);

        prefs = this.getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        String Name = prefs.getString("Sfname", "Faculty 1");
        String Id = prefs.getString("Sfroll", "1");
        String Dept = prefs.getString("Sfdept", "CSE");

        nameT.setText(Name);
        rollT.setText(Id);
        deptT.setText(Dept);

    }

    public void EditDetails(View view) {
        //open edit screen
        Intent intent = new Intent(this, EditDetailsActivity.class);
        startActivity(intent);
    }
}