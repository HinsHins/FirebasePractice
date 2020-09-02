package com.example.practice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.example.practice.StudentActivity.Student
import com.google.firebase.database.ktx.getValue
import kotlinx.android.synthetic.main.activity_showstudent.*

class ShowstudentActivity : AppCompatActivity() {
    private val students = ArrayList<String>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_showstudent)

        val myAdapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,students)
        studentListView.adapter = myAdapter

        val fb = FirebaseDatabase.getInstance()
        val ref = fb.reference
        val studentRef = ref.child("students")
        studentRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                for (data in snapshot.children.iterator()) {
                    val student = data.getValue<Student>()
                    if (student != null) {
                        students.add(student.toString())
                        myAdapter.notifyDataSetChanged()
                        Log.d("id", student.id)
                        Log.d("name", student.name)
                        Log.d("country", student.country)
                        Log.d("programme", student.programme)
                        Log.d("entryYear", student.entryYear)
                    }
                }
            }
            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })

    }
}