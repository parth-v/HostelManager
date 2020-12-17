package com.example.hostelmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class AdminActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
    }

    public void clickStudent(View view) {
        Intent intent = new Intent(this, StudentDetails.class);
        startActivity(intent);
    }

    public void clickStaff(View view) {
        Intent intent = new Intent(this, StaffDetails.class);
        startActivity(intent);
    }
}