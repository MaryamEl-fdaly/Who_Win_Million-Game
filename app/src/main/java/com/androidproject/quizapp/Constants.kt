package com.androidproject.quizapp

object Constants{

    const val message: String ="final_message"
    const val correctAnswer: String ="correct_answer"

    fun getQuestions(): ArrayList<Question> {
        val questionList = ArrayList<Question>()
        //Question1
        val Q1 = Question(
            1,
            "The chemical symbol K represents the element...",
            "A:Oxygen",
            "B:Potassium",
            "C:Uranium",
            "D:Krypton",
            100,
            2)

        questionList.add(Q1)

        //Question2
        val Q2 = Question(
            1,
            "The chemical symbol O represents the element...",
            "Oxygen",
            "Potassium",
            "Uranium",
            "Krypton",
            200,
            1)

        questionList.add(Q2)

        //Question3
        val Q3 = Question(
            1,
            "The chemical symbol U represents the element...",
            "Oxygen",
            "Potassium",
            "Uranium",
            "Krypton",
            300,
            3)

        questionList.add(Q3)

        //Question4
        val Q4 = Question(
            1,
            "The chemical symbol Ne represents the element...",
            "Oxygen",
            "Potassium",
            "Uranium",
            "Neon",
            500,
            4)

        questionList.add(Q4)

        //Question5
        val Q5 = Question(
            1,
            "The chemical symbol K represents the element...",
            "Oxygen",
            "Potassium",
            "Uranium",
            "Krypton",
            1000,
            2)

        questionList.add(Q5)

        //Question6
        val Q6 = Question(
            1,
            "The chemical symbol K represents the element...",
            "Oxygen",
            "Potassium",
            "Uranium",
            "Krypton",
            2000,
            2)

        questionList.add(Q6)

        //Question7
        val Q7 = Question(
            1,
            "The chemical symbol K represents the element...",
            "Oxygen",
            "Potassium",
            "Uranium",
            "Krypton",
            4000,
            2)

        questionList.add(Q7)

        //Question8
        val Q8 = Question(
            1,
            "The chemical symbol K represents the element...",
            "Oxygen",
            "Potassium",
            "Uranium",
            "Krypton",
            8000,
            2)

        questionList.add(Q8)

        //Question9
        val Q9 = Question(
            1,
            "The chemical symbol K represents the element...",
            "Oxygen",
            "Potassium",
            "Uranium",
            "Krypton",
            16000,
            2)

        questionList.add(Q9)

        //Question10
        val Q10 = Question(
            1,
            "The chemical symbol K represents the element...",
            "Oxygen",
            "Potassium",
            "Uranium",
            "Krypton",
            32000,
            2)

        questionList.add(Q10)

        //Question11
        val Q11 = Question(
            1,
            "The chemical symbol K represents the element...",
            "Oxygen",
            "Potassium",
            "Uranium",
            "Krypton",
            64000,
            2)

        questionList.add(Q11)

        //Question12
        val Q12 = Question(
            1,
            "The chemical symbol K represents the element...",
            "Oxygen",
            "Potassium",
            "Uranium",
            "Krypton",
            125000,
            2)

        questionList.add(Q12)

        //Question13
        val Q13 = Question(
            1,
            "The chemical symbol K represents the element...",
            "Oxygen",
            "Potassium",
            "Uranium",
            "Krypton",
            250000,
            2)

        questionList.add(Q13)

        //Question14
        val Q14 = Question(
            1,
            "The chemical symbol K represents the element...",
            "Oxygen",
            "Potassium",
            "Uranium",
            "Krypton",
            500000,
            2)

        questionList.add(Q14)

        //Question15
        val Q15 = Question(
            1,
            "The chemical symbol K represents the element...",
            "Oxygen",
            "Potassium",
            "Uranium",
            "Krypton",
            1000000,
            2)

        questionList.add(Q15)

        return questionList

    }




}