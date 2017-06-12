package com.lhyla.p23databinding;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Telephony;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class StartingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_starting);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.start_act_go_main_act_btn)
    protected void goMainAct() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.start_act_go_load_image_act_btn)
    protected void goImageLoadAct() {
        Intent i = new Intent(this,LoadImageActivity.class);
        startActivity(i);
    }

    @OnClick(R.id.start_act_go_sms_act_btn)
    protected void goSmsAct(){
        Intent i = new Intent(this,SMSActivity.class);
        startActivity(i);
    }

    @OnClick(R.id.start_act_go_stone_paper_scissors_game_btn)
    protected void goStonePaperScissorsGameAct(){
        Intent intent = new Intent(this,StonePaperScissorsActivity.class);
        startActivity(intent);
    }

}
