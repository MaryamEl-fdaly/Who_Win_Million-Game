package com.androidproject.quizapp

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.androidproject.quizapp.databinding.ActivityMainBinding
import kotlin.system.exitProcess

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    var mMediaPlayer : MediaPlayer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        playSound()



        binding.btnNewgame.setOnClickListener {
            val i: Intent = Intent(this, New_Game:: class.java)
            startActivity(i)
        }
        binding.btnQuit.setOnClickListener{
            finish()
            exitProcess(0);
        }
        binding.btnInstructions.setOnClickListener{
            var dialog = customdialogfragment()

            dialog.show(supportFragmentManager,"customDialog")
        }
        binding.btnLanguage.setOnClickListener{
            var dialog = languagecustomdialog()

            dialog.show(supportFragmentManager,"customDialog")
        }

        binding.btnPausemusic.setOnClickListener{
          if(mMediaPlayer!!.isPlaying)
          {
              pauseSound()
          }
            else
          {
              playSound()
          }
        }

        }

    fun playSound() {

            mMediaPlayer = MediaPlayer.create(this, R.raw.million)
            mMediaPlayer!!.isLooping = true
            mMediaPlayer!!.start()

    }
    fun pauseSound() {
        if (mMediaPlayer != null && mMediaPlayer!!.isPlaying) mMediaPlayer!!.pause()
    }

    fun stopSound() {
        if (mMediaPlayer != null) {
            mMediaPlayer!!.stop()
            mMediaPlayer!!.release()
            mMediaPlayer = null
        }
    }

    override fun onStop() {
        super.onStop()
        if (mMediaPlayer != null) {
            mMediaPlayer!!.release()
            mMediaPlayer = null
        }
    }
}

