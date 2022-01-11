package com.androidproject.quizapp;

import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.androidproject.quizapp.databinding.ActivityMainBinding
import kotlin.system.exitProcess


class MainActivity : AppCompatActivity() {

    var mediaplayer : MediaPlayer? = null
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        mediaplayer = MediaPlayer.create(this, R.raw.million);
        mediaplayer!!.isLooping = true;
        mediaplayer!!.start();

        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN



        binding.btnNewgame.setOnClickListener {
            val i: Intent = Intent(this, New_Game:: class.java)
            startActivity(i)
            finish()
        }
        binding.btnQuit.setOnClickListener{
            finish()
            exitProcess(0);
        }
        binding.btnInstructions.setOnClickListener{
            var dialog = customdialogfragment()

            dialog.show(supportFragmentManager,"customDialog")
        }
        binding.btnSetting.setOnClickListener{
                val ii: Intent = Intent(this,Setting::class.java)
                startActivity(ii)
        }

        }


}