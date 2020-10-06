package com.example.infs3634assignment1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    // DECLARE VARIABLES

    //public static final int number_min = 0;
    public static final int number_max = 100;
    public static final Random random = new Random();
    private TextView correctWrong;
    private EditText input;
    private Button guess;


    private int answer;
    private int turnsTaken;
    private int guessee;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        correctWrong = (TextView) findViewById(R.id.tvw_correctWrong);
        input = (EditText) findViewById (R.id.txt_enterNumber);
        guess = (Button) findViewById(R.id.btn_guess);
        guess.setOnClickListener(this);
        //turnsTaken = 5;
        newGame();
    }

    /*private Object findViewByID(int tvw_correctWrong) {
    }*/

    @Override
    public void onClick(View view){

        if (view == guess){
            guess();
        }
    }

    private void guess(){
        guessee = Integer.parseInt(input.getText().toString());

        // If guess is correct
        if (guessee == answer){
            //Toast.makeText(this, "Correct", Toast.LENGTH_SHORT).show();
            correctWrong.setText("Correct!");
            //newGame();
        }

        // If guess is incorrect
        else {

            // If you ran out of turns
            if (turnsTaken < 1+1){
                correctWrong.setText("You ran out of turns. Correct number is " + answer);
            }

            // If you still have turns
            else {

                // If guess is too high
                if (guessee > answer){
                    //Toast.makeText(this, "Too High", Toast.LENGTH_SHORT).show();
                    correctWrong.setText("Too High");
                    turnsTaken--;
                }

                // If guess is too low
                else if (guessee < answer){
                    //Toast.makeText(this, "Too Low", Toast.LENGTH_SHORT).show();
                    correctWrong.setText("Too Low");
                    turnsTaken--;
                }
            }
        }

        /*
        if(turnsTaken < 2){
            //Toast.makeText(this, "No Turns Left", Toast.LENGTH_SHORT).show();
            correctWrong.setText("You ran out of turns");
        }
        else{
            if (guessee == answer){
                //Toast.makeText(this, "Correct", Toast.LENGTH_SHORT).show();
                correctWrong.setText("Correct!");
                newGame();
            }
            else if (guessee > answer){
                //Toast.makeText(this, "Too High", Toast.LENGTH_SHORT).show();
                correctWrong.setText("Too High");
                turnsTaken--;
            }
            else if (guessee < answer){
                //Toast.makeText(this, "Too Low", Toast.LENGTH_SHORT).show();
                correctWrong.setText("Too Low");
                turnsTaken--;
            }

        }
        */

    }

    private void newGame(){
        answer = random.nextInt(number_max) + 1;
        correctWrong.setText("Guess the number");
        input.setText("");
        turnsTaken = 5;
    }
}