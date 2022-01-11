package com.androidproject.quizapp

import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.androidproject.quizapp.databinding.ActivitySettingBinding

class Setting : AppCompatActivity() {
    private lateinit var binding: ActivitySettingBinding
    private var mMediaPlayer : MediaPlayer? = null

    //lateinit var SeekBarVolume : SeekBar
   // lateinit var audiomanager: AudioManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySettingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN

        /*binding.btnMusic.setOnClickListener{
            playSound()
        }*/
        binding.btnPausemusic.setOnClickListener{
            stopSound()
        }
        binding.btnExit.setOnClickListener{
            val i: Intent = Intent(this,MainActivity::class.java)
            startActivity(i)
        }


     //   var maxVolume : Int = audiomanager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);


    }


    /*fun playSound() {
        if (mMediaPlayer == null) {
            mMediaPlayer = MediaPlayer.create(this, R.raw.million)
            mMediaPlayer!!.isLooping = true
            mMediaPlayer!!.start()
        } else mMediaPlayer!!.start()
    }
    fun pauseSound() {
        if (mMediaPlayer != null && mMediaPlayer!!.isPlaying) mMediaPlayer!!.pause()
    }*/
    private fun stopSound() {
        mMediaPlayer?.pause();
    }

    /*override fun onStop() {
        super.onStop()
        if (mMediaPlayer != null) {
            mMediaPlayer!!.release()
            mMediaPlayer = null
        }
}*/
}