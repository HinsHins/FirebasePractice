package com.example.practice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_student.*

class StudentActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student)
        FirebaseApp.initializeApp(this)

        val fb = FirebaseDatabase.getInstance()

        insert_student.setOnClickListener(object : View.OnClickListener {
            override fun onClick(p0: View?) {
                val id:String = sid_et.text.toString()
                val name:String = name_et.text.toString()
                val country:String = country_et.text.toString()
                val programme:String = programme_et.text.toString()
                val entryYear:String = year_et.text.toString()
                var student = Student(id, name, country,programme,entryYear)
                Log.d("Student", "$student")

                if (student != null) {
                    writeNewStudent(fb, student)
                    Toast.makeText(this@StudentActivity, "Insert successful", Toast.LENGTH_SHORT)
                        .show()
                }else
                    Toast.makeText(this@StudentActivity, "Please fill in all data before insert", Toast.LENGTH_SHORT).show()
            }
        })

    }

    data class Student(
        var id: String = "",
        var name:String = "",
        var country: String = "",
        var programme: String = "",
        var entryYear: String =""
    )

    private fun writeNewStudent(database:FirebaseDatabase ,student: Student) {

        database.getReference("students").child(student.id).setValue(student)
    }
}