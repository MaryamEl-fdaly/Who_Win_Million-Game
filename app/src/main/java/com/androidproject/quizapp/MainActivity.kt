package com.androidproject.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.androidproject.quizapp.databinding.ActivityMainBinding
import kotlin.system.exitProcess

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

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