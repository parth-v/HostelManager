package com.example.hostelmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class StaffActivity extends AppCompatActivity {
    EditText nameT, rollT, deptT;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staff);
    }

    public void onSubmit(View view) {

        String name = nameT.getText().toString();
        String roll = rollT.getText().toString();
        String dept = deptT.getText().toString();

        if(name.length()==0||roll.length()==0||dept.length()==0) {
            Toast.makeText(this, "Please provide all the details!", Toast.LENGTH_LONG).show();
            return;
        }

        String data = "New Staff Added\nName: " + name + "\nID: " + roll + "\nDept: " + dept;
        Toast.makeText(this, data, Toast.LENGTH_LONG).show();
    }
}