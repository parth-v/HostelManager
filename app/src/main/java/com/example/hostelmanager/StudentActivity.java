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

    //Shared pref used for storing student details
    public static final String MyPREFERENCES = "MyPrefs" ;
    public static final String Name = "Snname";
    public static final String Roll = "Snroll";
    public static final String Dept = "Sndept";
    public static final String Year = "Snyear";
    public static final String inTime = "SninTime";
    private TimePicker timePicker;
    private Calendar calendar;
    private String format = "";
    EditText nameT, rollT, deptT, yearT;
    private TextView time;
    SharedPreferences sharedpreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);
        nameT = (EditText) findViewById(R.id.mainName);
        rollT = (EditText) findViewById(R.id.mainRollNo);
        deptT = (EditText) findViewById(R.id.mainDept);
        yearT = (EditText) findViewById(R.id.mainYear);
        timePicker = (TimePicker) findViewById(R.id.timePicker1);
        time = (TextView) findViewById(R.id.OutHead);
        calendar = Calendar.getInstance();

        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);

        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int min = calendar.get(Calendar.MINUTE);

        showTime(hour, min);

    }

    public void setTime() {
        int hour = timePicker.getCurrentHour();
        int min = timePicker.getCurrentMinute();
        showTime(hour, min);
    }

    public void showTime(int hour, int min) {
        if (hour == 0) {
            hour += 12;
            format = "AM";
        } else if (hour == 12) {
            format = "PM";
        } else if (hour > 12) {
            hour -= 12;
            format = "PM";
        } else {
            format = "AM";
        }

        time.setText(new StringBuilder().append(hour).append(" : ").append(min)
                .append(" ").append(format));
    }

    public void onSubmit(View view) {
        String name = nameT.getText().toString();
        String roll = rollT.getText().toString();
        String dept = deptT.getText().toString();
        String year = yearT.getText().toString();
        setTime();
        String inTimeV = time.getText().toString();
        if(name.length()==0||roll.length()==0||dept.length()==0||year.length()==0) {
            Toast.makeText(this, "Please provide all the details!", Toast.LENGTH_LONG).show();
            return;
        }

        SharedPreferences.Editor editor = sharedpreferences.edit();
        //Commit the student details to the shared pref using editor
        editor.putString(Name, name);
        editor.putString(Roll, roll);
        editor.putString(Dept, dept);
        editor.putString(Year, year);
        editor.putString(inTime, inTimeV);
        editor.apply();

        //Display the user feedback on successful submission of details
        String data = "New Student Added\nName: " + name + "\nID: " + roll + "\nDept: " + dept +"\nYear: " + year + "\nTime: " + inTimeV;
        Toast.makeText(this, data, Toast.LENGTH_LONG).show();
    }

}