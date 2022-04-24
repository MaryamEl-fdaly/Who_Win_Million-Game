package com.androidproject.quizapp


object refresh {


    fun getnewQuestions(): ArrayList<Question> {
        val questionList = ArrayList<Question>()
        //Question1
        val Q1 = Question(
            1,
            "Who was the queen of England during Shakespeare’s lifetime?",
            "A:Victoria",
            "B: Elizabeth I",
            "C: Elizabeth II",
            "D:Elizabeth III",
            2
        )

        questionList.add(Q1)

        //Question2
        val Q2 = Question(
            2,
            " Which F1 racer wins the most Grand Prix?.",
            "A:Michael Schumacher",
            "B:Sebastian Vettel",
            "C:Lewis Hamilton",
            "D:Sergio Perez",
            1
        )

        questionList.add(Q2)

        //Question3
        val Q3 = Question(
            3,
            " The first colour photo in the world was taken in which year?.",
            "A:1861",
            "B:1895",
            "C:1907",
            "D:1900",
            1
        )

        questionList.add(Q3)

        //Question4
        val Q4 = Question(
            4,
            "Which of the following edible food never gets expired?",
            "A:Barley",
            "B:Rye",
            "C:Honey",
            "D: rice",
            3
        )

        questionList.add(Q4)


        return questionList
    }
}