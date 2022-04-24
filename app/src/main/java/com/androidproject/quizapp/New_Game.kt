package com.androidproject.quizapp

//import com.androidproject.quizapp.Constants.correctAnswer
import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.androidproject.quizapp.databinding.ActivityNewGameBinding

class New_Game : AppCompatActivity() , View.OnClickListener{
    private lateinit var binding: ActivityNewGameBinding

    private var CurrentPostion: Int = 1
    private var QuestionsList: ArrayList<Question> ? = null
    private var SelectedAnswerIndex : Int = 0
    private var CorrectAnswers : Int =0
    private var currentQ : Int =0




    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityNewGameBinding.inflate(layoutInflater)
        setContentView(binding.root)

        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN

        QuestionsList = Constants.getQuestions()

        setQuestions()

        money(CurrentPostion)

        binding.optionone.setOnClickListener(this)
        binding.optiontwo.setOnClickListener(this)
        binding.optionthree.setOnClickListener(this)
        binding.optionfour.setOnClickListener(this)
        binding.btnNext.setOnClickListener(this)
        binding.btnExit.setOnClickListener(this)
        binding.refresh.setOnClickListener(this)
        binding.minustwo.setOnClickListener (this)


    }


    override fun onClick(v: View?) {
        when (v?.id) {

            id.optionone -> {
                selectedAnswerView(binding.optionone, 1)
            }
            id.optiontwo -> {
                selectedAnswerView(binding.optiontwo, 2)
            }
            id.optionthree -> {
                selectedAnswerView(binding.optionthree, 3)
            }
            id.optionfour -> {
                selectedAnswerView(binding.optionfour, 4)
            }
            id.btn_next -> {
                if (SelectedAnswerIndex == 0) {
                    CurrentPostion++

                    when {
                        CurrentPostion < 15 -> {
                            setQuestions()
                        }
                        else -> {
                            if(CorrectAnswers ==15)
                            {
                                val i = Intent(this, ResultActivity::class.java)

                                i.putExtra(Constants.message, "CONGRATULATIONS!! \n  YOU WIN MILLION")
                                i.putExtra(Constants.correctAnswer, CorrectAnswers)
                                startActivity(i)
                            }
                        }
                    }
                } else {

                    val question = QuestionsList?.get(rand.elementAt(CurrentPostion ))
                    var question2 = newQuestionsList?.get(randomValues)
                    if (binding.refresh.isPressed) {
                        if (question2!!.correctAnswer == SelectedAnswerIndex) {
                            CorrectAnswers++
                        } else {
                            Log.d("Gffq", "{$question2.correctAnswer}")
                            AnswerView(SelectedAnswerIndex, drawable.wrong_view)
                            wronganswer++
                        }
                        AnswerView(question2.correctAnswer, drawable.correct_view)
                        // binding.refresh.isPressed = false
                    } else {
                        if (question!!.correctAnswer != SelectedAnswerIndex) {
                            AnswerView(SelectedAnswerIndex, drawable.wrong_view)
                            wronganswer++
                        } else {
                            CorrectAnswers++
                        }
                        AnswerView(question.correctAnswer, drawable.correct_view)
                    }

                    if (binding.optionone.isClickable || binding.optiontwo.isClickable || binding.optionthree.isClickable || binding.optionfour.isClickable)
                    {
                        disableButtons(binding.optionone, binding.optiontwo,binding.optionthree, binding.optionfour)
                    }
                    if (wronganswer != 0) {
                        var dialog = Losingdialog()
                        dialog.show(supportFragmentManager, "customDialog")
                        disableButtons(binding.optionone, binding.optiontwo, binding.optionthree, binding.optionfour)
                        binding.refresh.isClickable = false
                        binding.minustwo.isClickable = false
                        binding.btnNext.isClickable = false
                        //   var i: Intent = Intent(this, MainActivity:: class.java)
                        //  startActivity(i)
                    }
                    SelectedAnswerIndex = 0
                }
            }
            id.refresh -> {
                setnewQuestions()
                markButtonDisable(binding.refresh)
            }
            id.btn_exit -> {
                var i: Intent = Intent(this, MainActivity::class.java)
                startActivity(i)
            }
            id.minustwo ->{
                deletetwo(binding.optionone, binding.optiontwo, binding.optionthree, binding.optionfour)

            }

        }
    }




    private fun setQuestions()
    {
        enableButtons(binding.optionone,binding.optiontwo,binding.optionthree,binding.optionfour)
        val question = QuestionsList!![CurrentPostion-1]
        defaultAnswersView()
        Currentprogress = CurrentPostion+1
        binding.progress.text = "$Currentprogress" + "/" + 15
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

    private fun deletetwo (optionone : TextView, optiontwo : TextView, optionthree : TextView, optionfour : TextView) {
        var deleteQ : Int = 0;
        val question = QuestionsList!![rand.elementAt(CurrentPostion )]

        //val corr = correctAnswer.toInt();
        val answers = ArrayList<TextView>()
        answers.add(0,binding.optionone)
        answers.add(1,binding.optiontwo)
        answers.add(2,binding.optionthree)
        answers.add(3,binding.optionfour)
        for (answer in answers){
            if (answers.indexOf(answer)+1 != question!!.correctAnswer){
                answer.isClickable=false;
                if(answers.indexOf(answer)==0)
                { markAnswerDisable(binding.optionone) }
                else if(answers.indexOf(answer)==1)
                { markAnswerDisable(binding.optiontwo) }
                else if(answers.indexOf(answer)==2)
                { markAnswerDisable(binding.optionthree) }
                else if(answers.indexOf(answer)==3)
                { markAnswerDisable(binding.optionfour) }
                deleteQ++;
            }
            if (deleteQ ==2) {break}
        }
        markButtonDisable(binding.minustwo)
    }

    @SuppressLint("ResourceAsColor")
    private fun markAnswerDisable(ans: TextView) {
        ans.isClickable = false
        ans.setTextColor(getApplication().getResources().getColor(color.white))
        ans?.setBackgroundColor(color.Bronze_Olive)
    }

    @SuppressLint("ResourceAsColor")
    private fun markButtonDisable(button: Button) {
        button?.isEnabled = false
        button?.setTextColor(getApplication().getResources().getColor(color.Dark_yellow))
        button?.setBackgroundColor(color.Bronze_Olive)
    }

    private fun defaultAnswersView() {
        val answers = ArrayList<TextView>()
        answers.add(0, binding.optionone)
        answers.add(1, binding.optiontwo)
        answers.add(2, binding.optionthree)
        answers.add(3, binding.optionfour)

        for (answer in answers) {
            answer.setTextColor(Color.parseColor("#5C5300"))
            answer.typeface = Typeface.DEFAULT
            answer.background = ContextCompat.getDrawable(this, drawable.custom_textview)
        }
    }



    private fun AnswerView(answer: Int, drwableView: Int) {
        when (answer) {
            1 -> {
                binding.optionone.background = ContextCompat.getDrawable(this, drwableView)
            }
            2 -> {
                binding.optiontwo.background = ContextCompat.getDrawable(this, drwableView)
            }
            3 -> {
                binding.optionthree.background = ContextCompat.getDrawable(this, drwableView)
            }
            4 -> {
                binding.optionfour.background = ContextCompat.getDrawable(this, drwableView)
            }

        }
    }

    private fun selectedAnswerView(tv: TextView, selectedAnswerNum: Int) {
        defaultAnswersView()
        SelectedAnswerIndex = selectedAnswerNum
        tv.setTextColor(Color.parseColor("#413B05"))
        tv.background = ContextCompat.getDrawable(this, drawable.selected_textview)
    }
    private fun money(mn:Int)
    {
        when  {
            CurrentPostion == 0 ->  {
                binding.money.text="100"
            }
            CurrentPostion == 1 ->  {
                binding.money.text="200"
            }
            CurrentPostion == 2 ->  {
                binding.money.text="300"
            }
            CurrentPostion == 3 ->  {
                binding.money.text="500"
            }
            CurrentPostion == 4 ->  {
                binding.money.text="1k"
            }
            CurrentPostion == 5 ->  {
                binding.money.text="2k"
            }
            CurrentPostion == 6 ->  {
                binding.money.text="4k"
            }
            CurrentPostion == 7->  {
                binding.money.text="8k"
            }
            CurrentPostion == 8 ->  {
                binding.money.text="16k"
            }
            CurrentPostion == 9 ->  {
                binding.money.text="32k"
            }
            CurrentPostion == 10 ->  {
                binding.money.text="64k"
            }
            CurrentPostion == 11 ->  {
                binding.money.text="125k"
            }
            CurrentPostion == 12 ->  {
                binding.money.text="250k"
            }
            CurrentPostion == 13 ->  {
                binding.money.text="500k"
            }
            CurrentPostion == 14 ->  {
                binding.money.text="1M"
            }


        }

    }


}

