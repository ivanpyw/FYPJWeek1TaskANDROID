package com.example.fypjweek1task

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.webkit.DateSorter
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.create_course.*
import java.text.SimpleDateFormat
import java.time.DateTimeException
import java.util.*

class create_course : AppCompatActivity() {

    private val dateFormat = SimpleDateFormat("dd MMM yyyy", Locale.US)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.create_course)
        Toast.makeText(this, "Firebase Connection Successful", Toast.LENGTH_LONG).show()

        //Calender
        val datestartselected = Calendar.getInstance()
        val dateendselected = Calendar.getInstance()

        Btn_CourseDateStart.setOnClickListener {
            val datePicker = DatePickerDialog(
                this,
                DatePickerDialog.OnDateSetListener { _, year, month, dayOfMonth ->
                    datestartselected.set(Calendar.YEAR, year)
                    datestartselected.set(Calendar.MONTH, month)
                    datestartselected.set(Calendar.DAY_OF_MONTH, dayOfMonth)

                    CourseDateStart.setText(dateFormat.format(datestartselected.time))
                },
                datestartselected.get(Calendar.YEAR),
                datestartselected.get(Calendar.MONTH),
                datestartselected.get(Calendar.DAY_OF_MONTH)
            )
            datePicker.show()
        }

        Btn_CourseDateEnd.setOnClickListener {
            val datePicker = DatePickerDialog(
                this,
                DatePickerDialog.OnDateSetListener { _, year, month, dayOfMonth ->
                    dateendselected.set(Calendar.YEAR, year)
                    dateendselected.set(Calendar.MONTH, month)
                    dateendselected.set(Calendar.DAY_OF_MONTH, dayOfMonth)

                    CourseDateEnd.setText(dateFormat.format(dateendselected.time))
                },
                dateendselected.get(Calendar.YEAR),
                dateendselected.get(Calendar.MONTH),
                dateendselected.get(Calendar.DAY_OF_MONTH)
            )
            datePicker.show()
        }
    }

    fun BtnValidate(v: View) {

        val CourseN: String = CourseName.text.toString()
        val CourseD: String = CourseDescription.text.toString()
        val CourseC: String = CourseCode.text.toString()
        val DateS: String = CourseDateStart.text.toString()
        val DateE: String = CourseDateEnd.text.toString()
        val Class_Size: String = ClassSize.text.toString()

        if (CourseN.isNullOrBlank() || CourseD.isNullOrBlank() || CourseC.isNullOrBlank() || DateS.isNullOrBlank() || DateE.isNullOrBlank() || Class_Size.isNullOrBlank() ) {

            if (CourseN.isNullOrBlank()) {
                CourseName.setError("Name Required")
            }
            if (CourseC.isNullOrBlank()) {
                CourseCode.setError("Code Required")
            }
            if (CourseD.isNullOrBlank()) {
                CourseDescription.setError("Description Required")
            }
            if (DateS.isNullOrBlank()) {
                CourseDateStart.setError("Date Start Required")
            }
            if (DateE.isNullOrBlank()) {
                CourseDateEnd.setError("Date End Required")
            }
            if (Class_Size.isNullOrBlank())
            {
                ClassSize.setError("Size Required")
            }
        }
        else
        {
            /*CourseInfo.set_Course_Name(Course_name.toString())
            CourseInfo.set_Course_Code(Course_code.toString())
            CourseInfo.set_Course_Description(Course_Desc.toString())
            CourseInfo.set_Course_DateStart(Course_DateStarted.toString())
            CourseInfo.set_Course_DateEnd(Course_DateEnded.toString())
            CourseInfo.set_Course_classSize(CourseClass_TotalSize.toString())*/

          // Pushing into database
            //Location of the data that we are going to push it in
            val ref = FirebaseDatabase.getInstance().getReference("Courses")
            val dataId: String = ref.push().key.toString()
            // saving the data
            val data_saved = SaveData(dataId, CourseN, CourseC, CourseD, DateS, DateE, Class_Size)

            ref.child(dataId).setValue(data_saved).addOnCompleteListener {
                CourseName.text.clear()
                CourseDescription.text.clear()
                CourseCode.text.clear()
                CourseDateStart.text.clear()
                CourseDateEnd.text.clear()
                ClassSize.text.clear()
                Toast.makeText(applicationContext, "Data Saved", Toast.LENGTH_LONG).show()
            }


        }


        /* var CourseInfo = applicationContext as AppGetSet

         val CourseN = findViewById<TextView>(R.id.CourseName)
         val Course_name: String? = CourseN.text.toString()

         val CourseC = findViewById<TextView>(R.id.CourseCode)
         val Course_code: String? = CourseC.text.toString()

         val CourseD = findViewById<TextView>(R.id.CourseDescription)
         val Course_Desc: String? = CourseD.text.toString()

         val CourseDateS = findViewById<TextView>(R.id.CourseDateStart)
         val Course_DateStarted: String? = CourseDateS.text.toString()

         val CourseDateE = findViewById<TextView>(R.id.CourseDateEnd)
         val Course_DateEnded: String? = CourseDateE.text.toString()

         val classS = findViewById<TextView>(R.id.ClassSize)
         val CourseClass_TotalSize: String? = classS.text.toString()


         if (Course_name.isNullOrBlank() || Course_code.isNullOrBlank() || Course_Desc.isNullOrBlank() || Course_DateStarted.isNullOrBlank() || Course_DateEnded.isNullOrBlank() || CourseClass_TotalSize.isNullOrBlank() ) {

             if (Course_name.isNullOrBlank()) {
                 CourseName.setError("Name Required")
             }
             if (Course_code.isNullOrBlank()) {
                 CourseCode.setError("Code Required")
             }
             if (Course_Desc.isNullOrBlank()) {
                 CourseDescription.setError("Description Required")
             }
             if (Course_DateStarted.isNullOrBlank()) {
                 CourseDateStart.setError("Date Start Required")
             }
             if (Course_DateEnded.isNullOrBlank()) {
                 CourseDateEnd.setError("Date End Required")
             }
             if (CourseClass_TotalSize.isNullOrBlank())
             {
                 ClassSize.setError("Size Required")
             }
         }
         else
         {
             /*CourseInfo.set_Course_Name(Course_name.toString())
             CourseInfo.set_Course_Code(Course_code.toString())
             CourseInfo.set_Course_Description(Course_Desc.toString())
             CourseInfo.set_Course_DateStart(Course_DateStarted.toString())
             CourseInfo.set_Course_DateEnd(Course_DateEnded.toString())
             CourseInfo.set_Course_classSize(CourseClass_TotalSize.toString())*/
             Toast.makeText(this, "successful", Toast.LENGTH_LONG).show()
         }

     }*/

    }


}