package edu.upc.eseiaat.pma.multiquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MultiQuizActivity extends AppCompatActivity {

    private int ids_answers[] = {
            R.id.answer1, R.id.answer2, R.id.answer3, R.id.answer4
    };
    private int correct_answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multi_quiz);

        String [] all_questions = getResources().getStringArray(R.array.all_questions);
        String q0 = all_questions[0];
        String [] parts = q0.split(";");

        TextView text_question = (TextView) findViewById(R.id.text_question);
        text_question.setText(parts[0]);



        for (int i = 0; i < ids_answers.length; i++){
            RadioButton rb = (RadioButton) findViewById(ids_answers[i]);
            String answer = parts[i+1];
            if (answer.charAt(0) == '*'){
                correct_answer = i;
                answer = answer.substring(1);
            }
            rb.setText(answer);
        }

        Button btn_check = (Button) findViewById(R.id.btn_check);
        
        final RadioGroup group = (RadioGroup) findViewById(R.id.answer_group);

        btn_check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = group.getCheckedRadioButtonId();
                int answer = -1;
                for(int i = 0; i < ids_answers.length; i++){
                    if (ids_answers[i] == id){
                        answer = i;
                    }
                }
                if (answer == correct_answer){
                    Toast.makeText(MultiQuizActivity.this, R.string.correct, Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MultiQuizActivity.this, R.string.incorrect, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
