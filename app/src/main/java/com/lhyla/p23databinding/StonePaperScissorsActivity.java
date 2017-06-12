package com.lhyla.p23databinding;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class StonePaperScissorsActivity extends AppCompatActivity {

    @BindView(R.id.main_act_comp_points_text_view)
    TextView compPointsTextView;

    @BindView(R.id.main_act_user_points_text_view)
    TextView userPointsTextView;

    @BindView(R.id.main_act_num_rounds_text_view)
    TextView roundsTextView;

    @BindView(R.id.main_act_computer_choice_img_view)
    ImageView computerChoiceImgView;

    @BindView(R.id.main_act_user_choice_img_view)
    ImageView userChoiceImgView;

    private static final String LOG = "LH";

    private Random random;
    private int compChoice;
    private int userChoice;
    private int duration;
    private int rounds;

    private int userPoints;
    private int compPoints;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stone_paper_scissors);
        ButterKnife.bind(this);
        random = new Random();
        rounds = 1;
        duration = Toast.LENGTH_SHORT;

        getApplicationContext();
    }


    @OnClick(R.id.main_act_user_choice_scissors_btn)
    public void scissorsOnClick() {
        userChoiceImgView.setImageResource(R.drawable.scissors);
        randomCompChoice();
        userChoice = 1;
        makeToast(whoWon());
        updateRoundsNum();
        updatePoints(whoWon());
        Log.d(LOG, "Rounds: " + String.valueOf(rounds));
    }

    @OnClick(R.id.main_act_user_choice_stone_btn)
    public void stoneOnClick() {
        userChoiceImgView.setImageResource(R.drawable.stone);
        randomCompChoice();
        userChoice = 2;
        makeToast(whoWon());
        updateRoundsNum();
        updatePoints(whoWon());
        updatePointsView();
        Log.d(LOG, "Rounds: " + String.valueOf(rounds));
    }

    @OnClick(R.id.main_act_user_choice_paper_btn)
    public void paperOnClick() {
        userChoiceImgView.setImageResource(R.drawable.paper_ball);
        randomCompChoice();
        userChoice = 3;
        makeToast(whoWon());
        updateRoundsNum();
        updatePoints(whoWon());
        updatePointsView();
        Log.d(LOG, "Rounds: " + String.valueOf(rounds));
    }

    private void updateRoundsNum() {
        if (rounds == 5) {
            rounds = 1;
        } else {
            rounds++;
        }
        roundsTextView.setText(String.valueOf(rounds));
    }

    private void updatePoints(Integer whoWon) {
        switch (whoWon) {
            case 1:
                compPoints++;
                break;
            case 2:
                userPoints++;
        }

        if (compPoints == 5) {
            rounds = 0;
        }
    }


    private void updatePointsView() {
        compPointsTextView.setText(String.valueOf(compPoints));
        userPointsTextView.setText(String.valueOf(userPoints));
    }

    private void randomCompInt() {
        compChoice = random.nextInt(3) + 1;
    }

    private void randomCompChoice() {
        randomCompInt();
        Log.d(LOG, String.valueOf(compChoice));

        if (compChoice == 1) {
            computerChoiceImgView.setImageResource(R.drawable.scissors);
        } else if (compChoice == 2) {
            computerChoiceImgView.setImageResource(R.drawable.stone);
        } else if (compChoice == 3) {
            computerChoiceImgView.setImageResource(R.drawable.paper_ball);
        }
    }

    private Integer whoWon() {

        if (userChoice == compChoice) {
            Log.d(LOG, "Draw");
            return 0;
        } else if (userChoice == 1 && compChoice == 2) {

            Log.d(LOG, "Computer won!");
            return 1;
        } else if (userChoice == 1 && compChoice == 3) {

            Log.d(LOG, "User won!");
            return 2;
        } else if (userChoice == 2 && compChoice == 1) {

            Log.d(LOG, "User won!");
            return 2;
        } else if (userChoice == 2 && compChoice == 3) {

            Log.d(LOG, "Computer won!");
            return 1;
        } else if (userChoice == 3 && compChoice == 1) {

            Log.d(LOG, "Computer won!");
            return 1;
        } else if (userChoice == 3 && compChoice == 2) {

            Log.d(LOG, "User won!");
            return 2;
        }
        return 0;
    }

    public void makeToast(Integer whoWon) {
        Context context = getApplicationContext();
        Toast toast = Toast.makeText(context, getToastText(whoWon), duration);
        toast.show();
    }

    private String getToastText(Integer whoWon) {
        switch (whoWon) {
            case 0:
                return "Draw";
            case 1:
                return "Computer won!";
            case 2:
                return "User won!";
        }
        return "Draw";
    }
}
