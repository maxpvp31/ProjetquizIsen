package fr.isen.boutellis.quizz

object Constants {

    fun getQuestions(): ArrayList<EasyQuestions>{
        val questionsList = ArrayList<EasyQuestions>()

        val Q1 = EasyQuestions(
            1,
            "Au Moyen-Âge, comment appelait-on les villages fortifiés ?",
            "Tour",
            "Bastide",
            "Château fort",
            "Rempart",
            2
        )

        questionsList.add(Q1)

        val Q2 = EasyQuestions(
            2,
            "Comment appelle-t-on le fruit du plaqueminier ?",
            "Kakou",
            "Kacha",
            "Kaki",
            "Kali",
            3
        )

        questionsList.add(Q2)

        val Q3 = EasyQuestions(
            3,
            "De quelle série de six films un champion de boxe est-il la vedette ?",
            "Ritchie",
            "Rocky",
            "Rambo",
            "Randy",
            2
        )

        questionsList.add(Q3)

        val Q4 = EasyQuestions(
            4,
            "Quel pays a pour capitale Katmandou ?",
            "Le Népal",
            "Le Tibet",
            "La Corée du Sud",
            "Le Pakistan",
            1
        )

        questionsList.add(Q4)

        val Q5 = EasyQuestions(
            5,
            "À quel groupe musical international doit-on la bande originale du film ?",
            "Queen",
            "Yes",
            "Led Zeppelin",
            "The Doors",
            1
        )

        questionsList.add(Q5)

        val Q6 = EasyQuestions(
            6,
            "À quelle classe animale le scorpion appartient-il ?",
            "Aux mammifères",
            "Aux reptiles",
            "Aux arachnides",
            "Aux insectes",
            3
        )

        questionsList.add(Q6)

        val Q7 = EasyQuestions(
            7,
            "Quel nom porte le logiciel de traitement de texte mis au point par Microsoft ?",
            "Access",
            "Word",
            "Excel",
            "PowerPoint",
            2
        )

        questionsList.add(Q7)

        val Q8 = EasyQuestions(
            8,
            "Dans le langage familier, comment appelle-t-on la dent du petit enfant ?",
            "Marmotte",
            "Menotte",
            "Quenotte",
            "Bouillotte",
            3
        )

        questionsList.add(Q8)

        val Q9 = EasyQuestions(
            9,
            "Quelle est la plus petite unité de mémoire utilisable sur un ordinateur ?",
            "Le byte",
            "Le mega",
            "Le bit",
            "Le giga",
            3
        )

        questionsList.add(Q9)

        val Q10 = EasyQuestions(
            10,
            "Quelle est la seule valeur à la roulette à porter la couleur verte ?",
            "Le zéro",
            "Le cinquante",
            "Le quarante",
            "Le treize",
            1
        )

        questionsList.add(Q10)



        return questionsList


    }
}