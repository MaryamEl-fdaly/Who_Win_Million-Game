package com.androidproject.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.activity.result.ActivityResult
import com.androidproject.quizapp.databinding.ActivityNewGameBinding
import com.androidproject.quizapp.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {
    private lateinit var binding: ActivityResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN

        val message = intent.getStringExtra(Constants.message)
        val correctAnswer = intent.getIntExtra(Constants.correctAnswer,0)
        binding.result.text = message
        binding.numCorrect.text = "$correctAnswer" + "/" +15

        binding.btnRestart.setOnClickListener{
            startActivity(Intent(this,MainActivity::class.java))
        }

    }
}