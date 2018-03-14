package com.example.android.opticsquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.question_1_correct_answer) RadioButton correct1;
    @BindView(R.id.question_2_correct_answer) RadioButton correct2;
    @BindView(R.id.question_5_correct_answer) RadioButton correct5;
    @BindView(R.id.question_6_correct_answer) RadioButton correct6;

    @BindView(R.id.edit_text_question_3)EditText answer3;

    @BindView(R.id.question_4_wrong_answer_1) CheckBox wrong4_1;
    @BindView(R.id.question_4_wrong_answer_2) CheckBox wrong4_2;
    @BindView(R.id.question_4_wrong_answer_3) CheckBox wrong4_3;
    @BindView(R.id.question_4_correct_answer_1) CheckBox correct4_1;
    @BindView(R.id.question_4_correct_answer_2) CheckBox correct4_2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }


    /**
     * sums up the points for each question and shows a toast depending on the sum
     *
     */
    public void submitQuiz(View view){
        int total = evaluateQuestion1() + evaluateQuestion2() + evaluateQuestion3() + evaluateQuestion4()
                + evaluateQuestion5() + evaluateQuestion6();
        String message = "";
        message += getString(R.string.you_have) + total + getString(R.string.maximum_points) + "\n";
        if (total == 6) {
            message += getString(R.string.awesome);
        } else if (total > 3) {
            message += getString(R.string.not_bad);
        } else {
            message+= getString(R.string.you_can_do_better);
        }

        // creates toast with the above crated result message and displays it
        Toast toast = Toast.makeText(this, message, Toast.LENGTH_SHORT);
        TextView text = toast.getView().findViewById(android.R.id.message);
        if( text != null) text.setGravity(Gravity.CENTER);
        toast.show();

    }

    /** checks if the correct answer(s) of each question is checked
     * if it is: return 1, otherwise 0
     **/

    private int evaluateQuestion1() {
        RadioButton correct = findViewById(R.id.question_1_correct_answer);
        if (correct.isChecked()){
            return 1;
        }
        return 0;
    }

    private int evaluateQuestion2() {
        RadioButton correct = findViewById(R.id.question_2_correct_answer);
        if (correct.isChecked()){
            return 1;
        }
        return 0;
    }

    private int evaluateQuestion3() {
        EditText answer = findViewById(R.id.edit_text_question_3);
        String answerString = answer.getText().toString();
        String correct1 = getString(R.string.two);
        String correct2 = getString(R.string.two_number);
        if (answerString.equalsIgnoreCase(correct1) || answerString.equals(correct2)) {
            return 1;
        }
        return 0;
    }

    private int evaluateQuestion4() {
        CheckBox wrongAnswer1 = findViewById(R.id.question_4_wrong_answer_1);
        CheckBox wrongAnswer2 = findViewById(R.id.question_4_wrong_answer_2);
        CheckBox wrongAnswer3 = findViewById(R.id.question_4_wrong_answer_3);
        CheckBox correctAnswer1 = findViewById(R.id.question_4_correct_answer_1);
        CheckBox correctAnswer2 = findViewById(R.id.question_4_correct_answer_2);

        // make sure all right answers are checked and all wrong answers are unchecked
        boolean correct = (!wrongAnswer1.isChecked() && !wrongAnswer2.isChecked() && !wrongAnswer3.isChecked() && correctAnswer1.isChecked() && correctAnswer2.isChecked());

        if (correct)
            return 1;
        return 0;
    }

    private int evaluateQuestion5() {
        RadioButton correct = findViewById(R.id.question_5_correct_answer);
        if (correct.isChecked()){
            return 1;
        }
        return 0;
    }

    private int evaluateQuestion6() {
        RadioButton correct = findViewById(R.id.question_6_correct_answer);
        if (correct.isChecked()){
            return 1;
        }
        return 0;
    }
}
