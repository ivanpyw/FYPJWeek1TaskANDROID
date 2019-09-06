package com.example.fypjweek1task

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.create_course.*
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Toast.makeText(this, "Firebase Connection Successful", Toast.LENGTH_LONG).show()

  /*  //Calender

        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)

        //Onclick show datepicker
        CourseDateStart.setOnClickListener {
           val dpd= DatePickerDialog(this, DatePickerDialog.OnDateSetListener { datePicker, mYear, mMonth, mDay ->
                CourseDateStart.setText(""+ mDay + "/" + mMonth + "/" + mYear)
            }, year, month, day)

        }*/

    }
}
