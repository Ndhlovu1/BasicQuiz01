package com.example.firebasequiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class QuizActivity extends AppCompatActivity {

    private TextView questionNum, questionTv;
    private Button btnOptionA, btnOptionB, btnOptionC, btnOptionD;

    ArrayList<QuizModel> quizModelArrayList;
    Random random;
    int currentScore = 0, questionAttempted = 1, currentPos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        questionNum = findViewById(R.id.TVQuestionAttempted);
        questionTv = findViewById(R.id.idTVQuestion);
        btnOptionA = findViewById(R.id.btnoptionA);
        btnOptionB = findViewById(R.id.btnoptionB);
        btnOptionC = findViewById(R.id.btnoptionC);
        btnOptionD = findViewById(R.id.btnoptionD);

        quizModelArrayList = new ArrayList<>();
        random = new Random();

        getQuestion();
        currentPos = random.nextInt(quizModelArrayList.size());


        setDataToViews(currentPos);
        btnOptionA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (quizModelArrayList.get(currentPos).getAnswer().trim().toLowerCase().equals(btnOptionA.getText().toString().trim().toLowerCase())){
                    currentScore++;
                }
                questionAttempted++;
                    currentPos = random.nextInt(quizModelArrayList.size());
                    setDataToViews(currentPos);

            }
        });

        btnOptionB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (quizModelArrayList.get(currentPos).getAnswer().trim().toLowerCase().equals(btnOptionB.getText().toString().trim().toLowerCase())){
                    currentScore++;
                }
                questionAttempted++;
                currentPos = random.nextInt(quizModelArrayList.size());
                setDataToViews(currentPos);

            }
        });

        btnOptionC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (quizModelArrayList.get(currentPos).getAnswer().trim().toLowerCase().equals(btnOptionC.getText().toString().trim().toLowerCase())){
                    currentScore++;
                }
                questionAttempted++;
                currentPos = random.nextInt(quizModelArrayList.size());
                setDataToViews(currentPos);
            }
        });

        btnOptionD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (quizModelArrayList.get(currentPos).getAnswer().trim().toLowerCase().equals(btnOptionD.getText().toString().trim().toLowerCase())){
                    currentScore++;
                }
                questionAttempted++;
                currentPos = random.nextInt(quizModelArrayList.size());
                setDataToViews(currentPos);
            }
        });

    }

    private void showScores(){
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(QuizActivity.this);
        View score_sheet = LayoutInflater.from(getApplicationContext()).inflate(R.layout.score_bottom_sheet,(LinearLayout)findViewById(R.id.score_layout));
        TextView scoreTV = score_sheet.findViewById(R.id.tvScore);
        Button restartTest = score_sheet.findViewById(R.id.btnRestart);
        scoreTV.setText("Your Score is : \n"+currentScore+" / 10");

        restartTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                questionAttempted = 0;
                currentPos = random.nextInt(quizModelArrayList.size());
                setDataToViews(currentPos);
                currentScore = 0;
                bottomSheetDialog.dismiss();

            }
        });

        bottomSheetDialog.setCancelable(false);
        bottomSheetDialog.setContentView(score_sheet);
        bottomSheetDialog.show();

    }


    private void setDataToViews(int currentPos) {

        if (questionAttempted == 5){
            showScores();
        }
        else {
            //Todo Simply double the amount of questions in the array, then have a 1/3rd of them appear!
            questionNum.setText("Question Attempted \n" + questionAttempted + "/5");
            questionTv.setText(quizModelArrayList.get(currentPos).getQuestion());
            btnOptionA.setText(quizModelArrayList.get(currentPos).getOptionA());
            btnOptionB.setText(quizModelArrayList.get(currentPos).getOptionB());
            btnOptionC.setText(quizModelArrayList.get(currentPos).getOptionC());
            btnOptionD.setText(quizModelArrayList.get(currentPos).getOptionD());


        }

    }

    private void getQuestion() {
        quizModelArrayList.add(new QuizModel("1 + 1","dd","2","fd","aa", "2"));

        quizModelArrayList.add(new QuizModel("What is the Capital City of Zimbabwe?","Harare","Windhoek","Lubangu","None of the above", "Harare"));

        quizModelArrayList.add(new QuizModel("What is U.N. Short for?","Unknown","United Namibia","United Nations","None of the above", "United Nations"));

        quizModelArrayList.add(new QuizModel("dd","dd","ss","fd","aa", "ss"));

        quizModelArrayList.add(new QuizModel("dd","dd","ss","fd","aa", "ss"));

        quizModelArrayList.add(new QuizModel("dd","dd","ss","fd","aa", "ss"));

        quizModelArrayList.add(new QuizModel("dd","dd","ss","fd","aa", "ss"));

        quizModelArrayList.add(new QuizModel("dd","dd","ss","fd","aa", "ss"));

        quizModelArrayList.add(new QuizModel("dd","dd","ss","fd","aa", "ss"));

        quizModelArrayList.add(new QuizModel("dd","dd","ss","fd","aa", "ss"));

    }
}