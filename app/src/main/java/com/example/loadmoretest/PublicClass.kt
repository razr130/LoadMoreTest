package com.example.loadmoretest

import android.content.Context
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class PublicClass(context: Context?) {
    fun printSomething(activity: AppCompatActivity) {
        Toast.makeText(activity.applicationContext, "Hello from example!", Toast.LENGTH_SHORT).show()
    }
}