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
        EditText editEmail = (EditText) findViewById(R.id.mainEmail);
        EditText editPassword = (EditText) findViewById(R.id.mainPassword);
        String email = editEmail.getText().toString();
        String password = editPassword.getText().toString();
        if(email.equals("admin@gmail.com") && password.equals("admin")) {
            //open Admin Activity
        }
        else if(email.equals("staff@gmail.com") && password.equals("staff")){
            //open Staff Activity
        }

        else if(email.equals("student@gmail.com") && password.equals("student")){
            //open Student Activity
        }
        else {
            Toast.makeText(this, "Invalid Username or Password!" , Toast.LENGTH_LONG).show();
        }
    }

}