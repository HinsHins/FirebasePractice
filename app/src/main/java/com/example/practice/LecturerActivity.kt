package com.example.practice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.google.firebase.FirebaseApp
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_lecturer.*
import kotlinx.android.synthetic.main.activity_module.*

class LecturerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lecturer)

        FirebaseApp.initializeApp(this)

        val fb = FirebaseDatabase.getInstance()

        insert_lecturer.setOnClickListener(object : View.OnClickListener {
            override fun onClick(p0: View?) {
                val lid: String = lid_et.text.toString()
                val lname: String = lname_et.text.toString()
                val department: String = department_et.text.toString()
                val school: String = school_et.text.toString()
                val post: String = post_et.text.toString()

                var lecturer = Lecturer(lid, lname, department, school, post)
                Log.d("Lecturer", "$lecturer")

                if (lecturer != null) {
                    writeNewLecturer(fb, lecturer)
                    Toast.makeText(this@LecturerActivity, "Insert successful", Toast.LENGTH_SHORT)
                        .show()
                }else
                    Toast.makeText(this@LecturerActivity, "Please fill in all data before insert", Toast.LENGTH_SHORT).show()
            }

        })

    }

    data class Lecturer(
        var lid: String = "",
        var lname:String = "",
        var department: String = "",
        var school: String = "",
        var post: String =""
    )

    private fun writeNewLecturer(database:FirebaseDatabase ,lecturer: Lecturer) {

        database.getReference("lecturers").child(lecturer.lid).setValue(lecturer)
    }
}