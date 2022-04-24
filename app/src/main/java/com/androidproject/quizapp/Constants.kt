package com.androidproject.quizapp

object Constants{

    const val message: String ="final_message"
    const val correctAnswer: String ="correct_answer"

    fun getQuestions(): ArrayList<Question> {
        val questionList = ArrayList<Question>()
        //Question1
        val Q1 = Question(
            1,
            "What is actually electricity?",
            "A:A flow of water",
            "B:A flow of air",
            "C:A flow of electrons",
            "D:A flow of atoms",
            3)

        questionList.add(Q1)

        //Question2
        val Q2 = Question(
            2,
            "Which of the following disorders is the fear of being alone?",
            "A:Agoraphobia",
            "B:Aerophobia",
            "C:Acrophobia",
            "D:Arachnophobia",
            1)

        questionList.add(Q2)

        //Question3
        val Q3 = Question(
            3,
            "What is the speed of sound?",
            "A:120 km/h",
            "B:1,200 km/h",
            "C:400 km/h",
            "D:700 km/h",
            2)

        questionList.add(Q3)

        //Question4
        val Q4 = Question(
            4,
            "Which of the following is a song by the German heavy metal band “Scorpions”?",
            "A:Stairway to Heaven",
            "B:Wind of Change",
            "C:Don’t Stop Me Now",
            "D:Hey Jude",
            2)

        questionList.add(Q4)

        //Question5
        val Q5 = Question(
            5,
            "What was the first country to use tanks in combat during World War I?",
            "A:France",
            "B:Japan",
            "C:Britain",
            "D:Germany",
            3)

        questionList.add(Q5)

        //Question6
        val Q6 = Question(
            6,
            "What do we call a newly hatched butterfly? ",
            "A:A moth",
            "B:A butter",
            "C:A caterpillar",
            "D: A chrysalis",
            3)

        questionList.add(Q6)

        //Question7
        val Q7 = Question(
            7,
            "What is the main component of the sun?",
            "A:Liquid lava",
            "B:Gas",
            "C:Molten iron",
            "D:Rock",
            2)

        questionList.add(Q7)

        //Question8
        val Q8 = Question(
            8,
            "Goulash is a type of beef soup in which country?",
            "A:Hungary",
            "B:Czech Republic",
            "C:Slovakia",
            "D:Ireland",
            1)

        questionList.add(Q8)

        //Question9
        val Q9 = Question(
            9,
            "Where did the powers of Spiderman come from?",
            "A:Born with",
            "B: Radioactive spider",
            "C: experiment",
            "D: Dream",
            2)

        questionList.add(Q9)

        //Question10
        val Q10 = Question(
            10,
            "In which country is Transylvania?",
            "A:Bulgaria",
            "B:Romania",
            "C:Croatia",
            "D:Serbia",
            2)

        questionList.add(Q10)

        //Question11
        val Q11 = Question(
            11,
            " In the series “Game of Thrones”, Winterfell is the ancestral home of which family?",
            "A:The Lannisters",
            "B:The Tully’s ",
            "C:The Starks",
            "D:The Targaryens",
            3)

        questionList.add(Q11)

        //Question12
        val Q12 = Question(
            12,
            "What does the term “SOS” commonly stand for?",
            "A:Save Our Sheep",
            "B:Save Our Ship",
            "C:Save Our Seal",
            "D:Save Our Souls",
            4)

        questionList.add(Q12)

        //Question13
        val Q13 = Question(
            13,
            "Which was the first film by Disney to be produced in colour?",
            "A:Toy Story",
            "B:Sleeping Beauty",
            "C:Snow White and the Seven Dwarfs",
            "D:Cinderella",
            3)

        questionList.add(Q13)

        //Question14
        val Q14 = Question(
            14,
            "Which company is known for publishing the Mario video game?",
            "A:Xbox",
            "B:Nintendo",
            "C:SEGA",
            "D:Electronic Arts",
            2)

        questionList.add(Q14)

        //Question15
        val Q15 = Question(
            15,
            " Neil Armstrong was the first astronaut in the world to step foot on the moon. Who was the second?",
            "A:Yuri Gagarin",
            "B:James Irwin",
            "C:Alan Bean",
            "D: Buzz Aldrin",
            4)

        questionList.add(Q15)

        //Question16
        val Q16 = Question(
            16,
            "How many time zones are there in total in the world?",
            "A:8",
            "B:16",
            "C:24",
            "D:32",
            3)

        questionList.add(Q16)


        //Question17
        val Q17 = Question(
            17,
            "What is the rarest type of blood in the human body?",
            "A: AB negative",
            "B:O positive",
            "C:B negative",
            "D:A positive",
            1)

        questionList.add(Q17)

        //Question18
        val Q18 = Question(
            18,
            "Cu is the chemical symbol for which element?",
            "A:Oxygen",
            "B:Copper",
            "C:Zinc",
            "D:Helium",
            2)

        questionList.add(Q18)

        //Question19
        val Q19 = Question(
            19,
            "Which kind of play is “Romeo and Juliet”?",
            "A:History",
            "B:Monologue",
            "C:Tragedy",
            "D:Comedy",
            3)

        questionList.add(Q19)

        return questionList

    }




}