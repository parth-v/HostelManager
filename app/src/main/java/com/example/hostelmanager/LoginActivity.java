package com.example.hostelmanager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void onClickLogin(View view) {

        //Check Login Details for valid input
        EditText editEmail = (EditText) findViewById(R.id.mainEmail);
        EditText editPassword = (EditText) findViewById(R.id.mainPassword);
        String email = editEmail.getText().toString();
        String password = editPassword.getText().toString();

        //Open admin/staff/student screen as per the credentials
        if(email.equals("admin@gmail.com") && password.equals("admin")) {
            openAdminActivity();
        }
        else if(email.equals("staff@gmail.com") && password.equals("staff")){
            openStaffActivity();
        }

        else if(email.equals("student@gmail.com") && password.equals("student")){
            openStudentActivity();
        }
        else {
            Toast.makeText(this, "Invalid Username or Password!" , Toast.LENGTH_LONG).show();
        }
    }

    public void openStaffActivity(){
        Intent intent = new Intent(this, StaffActivity.class);
        startActivity(intent);
    }

    public void openAdminActivity(){
        Intent intent = new Intent(this, AdminActivity.class);
        startActivity(intent);
    }

    public void openStudentActivity(){
        Intent intent = new Intent(this, StudentActivity.class);
        startActivity(intent);
    }

}