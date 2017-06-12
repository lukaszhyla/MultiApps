package com.lhyla.p23databinding;

import android.content.Intent;
import android.content.IntentFilter;
import android.databinding.DataBindingUtil;
import android.icu.text.LocaleDisplayNames;
import android.nfc.Tag;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.main_act_login_edit_text)
    TextView loginEditText;

    @BindView(R.id.main_act_password_edit_text)
    TextView passwordEditText;

    @BindView(R.id.main_act_additional_materials_checked_box)
    CheckBox additionalMaterialsCheckedBox;

    @BindView(R.id.main_act_age_edit_text)
    EditText ageEditText;

    boolean startTimerClicked;

    private final static String TAG = "LH";

    private Intent i;

//    private BatteryStatusReceiver batteryStatusReceiver = new BatteryStatusReceiver();
//    private IntentFilter intentFilterOn = new IntentFilter(Intent.ACTION_POWER_CONNECTED);
//    private IntentFilter intentFilterOf = new IntentFilter(Intent.ACTION_POWER_DISCONNECTED);

    @Override
    protected void onResume() {
        super.onResume();
//        registerReceiver(batteryStatusReceiver, intentFilterOn);
//        registerReceiver(batteryStatusReceiver, intentFilterOf);
    }

    @Override
    protected void onPause() {
//        unregisterReceiver(batteryStatusReceiver);
        super.onPause();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        i = new Intent(MainActivity.this, TimerService.class);
    }


    @OnClick(R.id.main_act_start_timer_btn)
    public void onStartTimerBtnClick(){
            MainActivity.this.startService(i);
            Log.d(TAG,"TimerBtnClick");
    }

    @OnClick(R.id.main_act_stop_timer_btn)
    public void onStopTimerBtnClick(){
            MainActivity.this.stopService(i);

            Log.d(TAG,"OnStopTimerClicked");
            startTimerClicked=false;
    }

    @OnClick(R.id.main_act_register_btn)
    public void onRegisterBtnClick() {
        Intent intent = new Intent(this, AfterRegisterActivity.class);

        User user = new User(loginEditText.getText().toString(),
                passwordEditText.getText().toString(),
                additionalMaterialsCheckedBox.isChecked(),
                ageEditText.getText().toString()
        );
        intent.putExtra("extraUser", user);
        startActivity(intent);
    }

    private boolean isLoginGood() {
        if (loginEditText.getText().toString().length() < 3) {
            return false;
        } else return true;
    }

    private boolean isPasswordGood() {
        if (passwordEditText.getText().toString().length() < 3) {
            return false;
        } else return true;

    }

    private boolean ageIsOver18(){

        String age = ageEditText.getText().toString();
        if(!age.isEmpty()){
            if (Integer.parseInt(age) < 18){
                Log.d(TAG,"Under 18!");
                return false;
            } Log.d(TAG, "Over 18") ;
            return true;
        } return false;
    }

    public boolean isLoginAndPasswordGood() {
        if (isLoginGood() && isPasswordGood()) {
            return true;
        } else return false;
    }



}
