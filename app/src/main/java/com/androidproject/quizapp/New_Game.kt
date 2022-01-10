package com.androidproject.quizapp

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.androidproject.quizapp.databinding.ActivityMainBinding
import com.androidproject.quizapp.databinding.ActivityNewGameBinding
import kotlin.system.exitProcess

class New_Game : AppCompatActivity() , View.OnClickListener{
    private lateinit var binding: ActivityNewGameBinding

    private var CurrentPostion: Int = 1
    private var QuestionsList: ArrayList<Question> ? = null
    private var SelectedAnswerIndex : Int = 0
    private var CorrectAnswers : Int =0


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityNewGameBinding.inflate(layoutInflater)
        setContentView(binding.root)

        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN

        QuestionsList = Constants.getQuestions()

        setQuestions()

        binding.optionone.setOnClickListener(this)
        binding.optiontwo.setOnClickListener(this)
        binding.optionthree.setOnClickListener(this)
        binding.optionfour.setOnClickListener(this)
        binding.btnNext.setOnClickListener(this)
        binding.btnExit.setOnClickListener(this)



    }
    private fun setQuestions()
    {

        enableButtons(binding.optionone,binding.optiontwo,binding.optionthree,binding.optionfour)
        val question = QuestionsList!![CurrentPostion-1]
        defaultAnswersView()


        binding.progress.text = "$CurrentPostion" + "/" +15
        binding.question.text = question!!.question
        binding.optionone.text = question.optionOne
        binding.optiontwo.text = question.optionTwo
        binding.optionthree.text = question.optionThree
        binding.optionfour.text = question.optionFour
    }
    fun disableButtons(optionone : TextView, optiontwo : TextView,optionthree : TextView, optionfour : TextView)
    {
        optionone.isClickable = false
        optiontwo.isClickable = false
        optionthree.isClickable = false
        optionfour.isClickable = false
    }
    fun enableButtons(optionone : TextView, optiontwo : TextView,optionthree : TextView, optionfour : TextView)
    {
        optionone.isClickable = true
        optiontwo.isClickable = true
        optionthree.isClickable = true
        optionfour.isClickable = true
    }

    private fun defaultAnswersView()
    {
        val answers = ArrayList<TextView>()
        answers.add(0,binding.optionone)
        answers.add(1,binding.optiontwo)
        answers.add(2,binding.optionthree)
        answers.add(3,binding.optionfour)

        for (answer in answers)
        {
            answer.setTextColor(Color.parseColor("#5C5300"))
            answer.typeface = Typeface.DEFAULT
            answer.background = ContextCompat.getDrawable(this,R.drawable.custom_textview)
        }
    }

    override fun onClick(v: View?) {
        when(v?.id)
        {
            R.id.optionone -> {
                selectedAnswerView(binding.optionone,1)
            }
            R.id.optiontwo -> {
                selectedAnswerView(binding.optiontwo,2)
            }
            R.id.optionthree -> {
                selectedAnswerView(binding.optionthree,3)
            }
            R.id.optionfour -> {
                selectedAnswerView(binding.optionfour,4)
            }
            R.id.btn_next ->{
                if(SelectedAnswerIndex ==0)
                {
                    CurrentPostion++

                    when{CurrentPostion <= QuestionsList!!.size ->
                    {
                        setQuestions()
                    }
                    else->
                    {
                       val i = Intent(this,ResultActivity::class.java)
                        if(CorrectAnswers == 15)
                        {
                            i.putExtra(Constants.message,"CONGRATULATIONS!! \n  YOU WIN MILLION")
                            i.putExtra(Constants.correctAnswer,CorrectAnswers)

                        }
                        else{
                            i.putExtra(Constants.message,"        YOU LOST! \n         Try Again")
                            i.putExtra(Constants.correctAnswer,CorrectAnswers)

                        }
                        startActivity(i)
                    }
                    }
                }
                else{
                    val question = QuestionsList?.get(CurrentPostion-1)
                    if(question!!.correctAnswer != SelectedAnswerIndex)
                    {
                       AnswerView(SelectedAnswerIndex, R.drawable.wrong_view)
                    }
                    else
                    {
                        CorrectAnswers++
                    }
                    AnswerView(question.correctAnswer,R.drawable.correct_view)
                    if(binding.optionone.isClickable == true || binding.optiontwo.isClickable == true || binding.optionthree.isClickable == true || binding.optionfour.isClickable == true )
                    {
                        disableButtons(binding.optionone,binding.optiontwo,binding.optionthree,binding.optionfour)
                    }

                    SelectedAnswerIndex =0
                }
            }
            R.id.btn_exit ->{
                finish();
            }
        }
    }

    private fun AnswerView(answer:Int, drwableView: Int)
    {
        when(answer)
        {
            1 ->
            {
                binding.optionone.background =ContextCompat.getDrawable(this, drwableView)
            }
            2 ->
            {
                binding.optiontwo.background =ContextCompat.getDrawable(this, drwableView)
            }
            3 ->
            {
                binding.optionthree.background =ContextCompat.getDrawable(this, drwableView)
            }
            4 ->
            {
                binding.optionfour.background =ContextCompat.getDrawable(this, drwableView)
            }

        }
    }

    private fun selectedAnswerView(tv: TextView, selectedAnswerNum: Int)
    {
        defaultAnswersView()
        SelectedAnswerIndex = selectedAnswerNum
        tv.setTextColor(Color.parseColor("#413B05"))
        tv.background = ContextCompat.getDrawable(this,R.drawable.selected_textview)
    }

}