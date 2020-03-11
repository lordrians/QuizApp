package com.example.quizapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class QuestionAdapter extends RecyclerView.Adapter<QuestionAdapter.ViewHolder> {

    private Context mContext;
    private ArrayList<Question> quesList;

    public QuestionAdapter(Context mContext, ArrayList<Question> quesList){
        this.mContext = mContext;
        this.quesList = quesList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.list_question, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {

        Question question = quesList.get(position);


        holder.tvQuestion.setText(question.getQuestion());
        holder.btnOptionA.setText(question.getOption_a());
        holder.btnOptionB.setText(question.getOption_b());
        holder.btnOptionC.setText(question.getOption_c());
        holder.btnOptionD.setText(question.getOption_d());

        holder.btnOptionA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (holder.btnOptionA.getText().toString().equals(quesList.get(position).getCorrect_answer())){
                    holder.btnOptionA.setBackgroundResource(R.drawable.selected_button);
//                    Toast.makeText(mContext, "Jawaban Benar",Toast.LENGTH_LONG).show();
                    Global.score +=10;
                    Toast.makeText(mContext, String.valueOf(Global.score), Toast.LENGTH_LONG).show();


                }else {
//                    Toast.makeText(mContext, "Jawaban Salah",Toast.LENGTH_LONG).show();

                }
                removeItem(position, holder);
            }
        });

        holder.btnOptionB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (holder.btnOptionB.getText().toString().equals(quesList.get(position).getCorrect_answer())){
//                    Toast.makeText(mContext, "Jawaban Benar",Toast.LENGTH_LONG).show();
                    Global.score +=10;
                    Toast.makeText(mContext, String.valueOf(Global.score), Toast.LENGTH_LONG).show();

                }else {
//                    Toast.makeText(mContext, "Jawaban Salah",Toast.LENGTH_LONG).show();
                }
                removeItem(position, holder);
            }
        });

        holder.btnOptionC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (holder.btnOptionC.getText().toString().equals(quesList.get(position).getCorrect_answer())){
//                    Toast.makeText(mContext, "Jawaban Benar",Toast.LENGTH_LONG).show();
                    Global.score +=10;
                    Toast.makeText(mContext, String.valueOf(Global.score), Toast.LENGTH_LONG).show();
                }else {
//                    Toast.makeText(mContext, "Jawaban Salah",Toast.LENGTH_LONG).show();
                }
                removeItem(position, holder);
            }
        });

        holder.btnOptionD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (holder.btnOptionD.getText().toString().equals(quesList.get(position).getCorrect_answer())){
//                    Toast.makeText(mContext, "Jawaban Benar",Toast.LENGTH_LONG).show();
                    Global.score +=10;
                    Toast.makeText(mContext, String.valueOf(Global.score), Toast.LENGTH_LONG).show();

                }else {
//                    Toast.makeText(mContext, "Jawaban Salah",Toast.LENGTH_LONG).show();
                }
                removeItem(position, holder);
            }
        });
        



    }

    private void removeItem(int position, ViewHolder holder) {

        if (quesList.size() == 1){
//            holder.itemView.setVisibility(View.INVISIBLE);
            quesList.remove(position);
            notifyItemRemoved(position);
            notifyItemChanged(position);
            notifyItemRangeChanged(position, quesList.size());
            mContext.startActivity(new Intent(mContext, QuestionActivity.class));
        }else {
//            holder.itemView.setVisibility(View.INVISIBLE);
            quesList.remove(position);
            notifyItemRemoved(position);
            notifyItemChanged(position);
            notifyItemRangeChanged(position, quesList.size());
//            Toast.makeText(mContext, "Array" + String.valueOf(quesList.size()), Toast.LENGTH_SHORT).show();
        }

        
    }


    @Override
    public int getItemCount() {
        return quesList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvQuestion;
        Button btnOptionA, btnOptionB, btnOptionC, btnOptionD;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvQuestion = itemView.findViewById(R.id.tv_list_question);
            btnOptionA = itemView.findViewById(R.id.btn_list_option_a);
            btnOptionB = itemView.findViewById(R.id.btn_list_option_b);
            btnOptionC = itemView.findViewById(R.id.btn_list_option_c);
            btnOptionD = itemView.findViewById(R.id.btn_list_option_d);

        }
    }
}
