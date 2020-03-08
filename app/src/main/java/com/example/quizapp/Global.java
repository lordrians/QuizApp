package com.example.quizapp;

import java.util.ArrayList;
import java.util.List;

public class Global {

    public static final String DOMAIN_URL = "http://192.168.1.10/quizapps/";
    public static final String SHOW_QUESTION_URL = DOMAIN_URL + "show_question.php";

    public static int score = 0 ;

    public static List<Question> questionsList = new ArrayList<>();

}
