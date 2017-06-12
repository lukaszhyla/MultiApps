package com.lhyla.p23databinding;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by RENT on 2017-06-07.
 */

public class BatteryStatusReceiver extends BroadcastReceiver{
    @Override
    public void onReceive(Context context, Intent intent) {
        CharSequence text1 = "Battery is charging!";
        CharSequence text2 = "Battery is not charging";
        int duration = Toast.LENGTH_LONG;
        if(intent.getAction() == Intent.ACTION_POWER_CONNECTED){
            Toast.makeText(context, text1, duration).show();
        } if(intent.getAction() == Intent.ACTION_POWER_DISCONNECTED) {
            Toast.makeText(context, text2, duration).show();
        }
    }
}
