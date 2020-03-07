package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Button btnOptionA, btnOptionB, btnOptionC, btnOptionD;

    TextView tvQuestion;
    String result;
    int index = 0;
    List<Question> list=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvQuestion = findViewById(R.id.tv_question);
        btnOptionA = findViewById(R.id.btn_option_a);
        btnOptionB = findViewById(R.id.btn_option_b);
        btnOptionC = findViewById(R.id.btn_option_c);
        btnOptionD = findViewById(R.id.btn_option_d);

        loadQuestion();

    }

    public void loadQuestion() {

        StringRequest stringRequest = new StringRequest(Request.Method.GET, Global.SHOW_QUESTION_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            parseJson(response);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_LONG).show();
            }
        });

        Volley.newRequestQueue(getApplicationContext()).add(stringRequest);
    }

    public void parseJson(String response) throws JSONException {
        JSONArray jsonArray = new JSONArray(response);
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject questionObj = jsonArray.getJSONObject(i);

            int id = questionObj.getInt("id");
            String question = questionObj.getString("question");
            String option_a = questionObj.getString("option_a");
            String option_b = questionObj.getString("option_b");
            String option_c = questionObj.getString("option_c");
            String option_d = questionObj.getString("option_d");
            String correct_answer = questionObj.getString("correct_answer");

            Question questionClass = new Question(id, question, option_a, option_b, option_c, option_d, correct_answer);
            Global.questionsList.add(questionClass);

        }
        if (list.size() == jsonArray.length()){
            setData();
        }
        else {
            btnOptionA.setText("Belum penuh");
        }
    }

    private void setData() {


        if (index < Global.questionsList.size()){

        }

    }
}
