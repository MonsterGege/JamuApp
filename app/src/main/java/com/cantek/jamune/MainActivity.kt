package com.cantek.jamune

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class MainActivity : Activity() {
    private lateinit var title: TextView
    private lateinit var ket: TextView
    private lateinit var img: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


       // title = findViewById(R.id.jdl)
       // ket = findViewById(R.id.keterangan)

    }
}