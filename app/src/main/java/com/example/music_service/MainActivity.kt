package com.example.music_service

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.music_service.MyService
import com.example.music_service.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { view, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            view.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        findViewById<Button>(R.id.playbtn).setOnClickListener {
            startService(Intent(applicationContext, MyService::class.java).apply {
                putExtra("ServiceAction", "PlayPause")
            })
        }

        findViewById<Button>(R.id.stopbtn).setOnClickListener {
            stopService(Intent(applicationContext, MyService::class.java).apply {
                putExtra("ServiceAction", "PlayPause")
            })
        }
    }
}