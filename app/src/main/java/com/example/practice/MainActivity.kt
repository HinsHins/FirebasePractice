package com.example.practice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        student_button.setOnClickListener(object : View.OnClickListener {
            override fun onClick(p0: View?) {
                val myIntent = Intent(this@MainActivity, StudentActivity::class.java)
                startActivity(myIntent)
            }
        })


        lecturer_button.setOnClickListener(object : View.OnClickListener {
            override fun onClick(p0: View?) {
                val myIntent = Intent(this@MainActivity, LecturerActivity::class.java)
                startActivity(myIntent)
            }
        })


        module_button.setOnClickListener(object : View.OnClickListener {
            override fun onClick(p0: View?) {
                val myIntent = Intent(this@MainActivity, ModuleActivity::class.java)
                startActivity(myIntent)
            }
        })

        shown_student_button.setOnClickListener(object : View.OnClickListener {
            override fun onClick(p0: View?) {
                val myIntent = Intent(this@MainActivity, ShowstudentActivity::class.java)
                startActivity(myIntent)
            }
        })


    }
}