package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
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

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    RecyclerView rvQuestion;
    QuestionAdapter questionAdapter;
    ArrayList<Question> quesArrayList;

    Button btnOptionA, btnOptionB, btnOptionC, btnOptionD, btnMulai;

    TextView tvQuestion;
    int index = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        quesArrayList = new ArrayList<>();
        rvQuestion = findViewById(R.id.rv_question);
        rvQuestion.setHasFixedSize(true);
        rvQuestion.setLayoutManager(new LinearLayoutManager(this));

        loadQuestion();



    }


    public void loadQuestion() {

        StringRequest stringRequest = new StringRequest(Request.Method.GET, Global.SHOW_QUESTION_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONArray jsonArray = new JSONArray(response);
                            for (int i = 0; i < jsonArray.length(); i++){
                                JSONObject questionObj = jsonArray.getJSONObject(i);
                                int id = questionObj.getInt("id");
                                String question = questionObj.getString("question");
                                String option_a = questionObj.getString("option_a");
                                String option_b = questionObj.getString("option_b");
                                String option_c = questionObj.getString("option_c");
                                String option_d = questionObj.getString("option_d");
                                String correct_answer = questionObj.getString("correct_answer");
                                Question questionClass = new Question(id, question, option_a, option_b, option_c, option_d, correct_answer);
                                quesArrayList.add(questionClass);
                            }

                            questionAdapter = new QuestionAdapter(MainActivity.this, quesArrayList);
                            rvQuestion.setAdapter(questionAdapter);

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




    @Override
    public void onClick(View v) {
        switch (v.getId()){


        }

    }
}