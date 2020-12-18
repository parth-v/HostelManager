package com.example.hostelmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class StudentActivity extends AppCompatActivity {

    public static final String MyPREFERENCES = "MyPrefs" ;
    public static final String Name = "SnnameK";
    public static final String Roll = "SnrollK";
    public static final String Dept = "SndeptK";
    public static final String Year = "SnyearK";
    public static final String inTime = "SninTimeK";
    public static final String outTime = "SnoutTimeK";
    private TimePicker timePicker1, timePicker2;
    private Calendar calendar1, calendar2;
    private String format1 = "", format2 = "";
    EditText nameT, rollT, deptT, yearT;
    private TextView time1, time2;
    SharedPreferences sharedpreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);
        nameT = (EditText) findViewById(R.id.mainName);
        rollT = (EditText) findViewById(R.id.mainRollNo);
        deptT = (EditText) findViewById(R.id.mainDept);
        yearT = (EditText) findViewById(R.id.mainYear);
        timePicker1 = (TimePicker) findViewById(R.id.timePicker1);
        timePicker1 = (TimePicker) findViewById(R.id.timePicker1);
        calendar1 = Calendar.getInstance();
        calendar2 = Calendar.getInstance();

        int hour1 = calendar1.get(Calendar.HOUR_OF_DAY);
        int min1 = calendar1.get(Calendar.MINUTE);

        int hour2 = calendar2.get(Calendar.HOUR_OF_DAY);
        int min2 = calendar2.get(Calendar.MINUTE);

        //Time function

        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
    }

    public void onSubmit(View view) {
        String name = nameT.getText().toString();
        String roll = rollT.getText().toString();
        String dept = deptT.getText().toString();
        String year = yearT.getText().toString();
        String inTimeV = time1.getText().toString();
        String outTimeV = time2.getText().toString();

        if(name.length()==0||roll.length()==0||dept.length()==0||year.length()==0) {
            Toast.makeText(this, "Please provide all the details!", Toast.LENGTH_LONG).show();
            return;
        }

        SharedPreferences.Editor editor = sharedpreferences.edit();

        editor.putString(Name, name);
        editor.putString(Roll, roll);
        editor.putString(Dept, dept);
        editor.putString(Year, name);
        editor.putString(inTime, inTimeV);
        editor.putString(outTime, outTimeV);
        editor.commit();

        String data = "New Student Added\nName: " + name + "\nID: " + roll + "\nDept: " + dept +"\nYear: " + year;
        Toast.makeText(this, data, Toast.LENGTH_LONG).show();
    }

}