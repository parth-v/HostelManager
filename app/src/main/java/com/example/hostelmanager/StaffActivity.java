package com.example.hostelmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class StaffActivity extends AppCompatActivity {

    //Shared pref used for storing staff name, roll no and dept
    public static final String MyPREFERENCES = "MyPrefs" ;
    public static final String Name = "SfnameK";
    public static final String Roll = "SfrollK";
    public static final String Dept = "SfdeptK";
    EditText nameT, rollT, deptT;
    SharedPreferences sharedpreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staff);
        nameT = (EditText) findViewById(R.id.mainSfName);
        rollT = (EditText) findViewById(R.id.mainSfRollNo);
        deptT = (EditText) findViewById(R.id.mainSfDept);

        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
    }

    public void onSubmit(View view) {

        //Called once staff details have been entered
        String name = nameT.getText().toString();
        String roll = rollT.getText().toString();
        String dept = deptT.getText().toString();

        //Check for blank input
        if(name.length()==0||roll.length()==0||dept.length()==0) {
            Toast.makeText(this, "Please provide all the details!", Toast.LENGTH_LONG).show();
            return;
        }

        SharedPreferences.Editor editor = sharedpreferences.edit();
        //Commit the staff details to the shared pref using editor
        editor.putString(Name, name);
        editor.putString(Roll, roll);
        editor.putString(Dept, dept);
        editor.apply();

        //Display the user feedback on successful submission of details
        String data = "New Staff Added\nName: " + name + "\nID: " + roll + "\nDept: " + dept;
        Toast.makeText(this, data, Toast.LENGTH_LONG).show();
    }
}