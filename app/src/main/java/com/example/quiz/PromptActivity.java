package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PromptActivity extends AppCompatActivity {
private boolean correctAnswer;
private TextView answerTextView;
private TextView text;
private Button answerButton;

    public static final String KEY_EXTRA_ANSWER_SHOWN="com.example.quiz.answerShown";
    //public static final String KEY_EXTRA_ANSWER_SHOWN="pb.edu.pl.wi.quiz.answerShown";

    private void setAnswerShownResult(boolean answerWasShown){
        Intent resultIntent= new Intent();
        resultIntent.putExtra(KEY_EXTRA_ANSWER_SHOWN,answerWasShown);
        setResult(RESULT_OK,resultIntent);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prompt);

        correctAnswer=getIntent().getBooleanExtra(MainActivity.KEY_EXTRA_ANSWER,true);

        answerButton=findViewById(R.id.answerButton);
        answerTextView=findViewById(R.id.answer_text_view); // Pole wyświetlania odpowiedzi
        text=findViewById(R.id.answerQuestion); // Pytanie czy chce zobaczyć odpowiedź

        answerButton.setOnClickListener(new View.OnClickListener(){
           @Override
           public void onClick(View v){
               int answer = correctAnswer? R.string.button_true : R.string.button_false;
               answerTextView.setText(answer);
               setAnswerShownResult(true);
           }
        });

    }

}