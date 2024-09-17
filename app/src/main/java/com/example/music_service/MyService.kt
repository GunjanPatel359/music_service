package com.example.music_service

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.IBinder
import android.util.Log

class MyService : Service() {

    private lateinit var mediaPlayer: MediaPlayer

    override fun onBind(intent: Intent): IBinder? {
        return null
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        if (!this::mediaPlayer.isInitialized) {
            mediaPlayer = MediaPlayer.create(this, R.raw.alarm)
        }
        intent?.let {
            val action = it.getStringExtra("ServiceAction")
            if (action == "PlayPause") {
                if (!mediaPlayer.isPlaying) {
                    mediaPlayer.start()
                } else {
                    mediaPlayer.pause()
                }
            }
        }

        return START_STICKY
    }

    override fun onDestroy() {
        if (this::mediaPlayer.isInitialized) {
            mediaPlayer.stop()
            mediaPlayer.release()
        }
        super.onDestroy()
    }
}