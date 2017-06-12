package com.lhyla.p23databinding;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by RENT on 2017-06-08.
 */

public class TimerService extends Service {

    private static final String TAG = "LH";
    private Timer timer;
    int counter;
    Toast toast;
    TimerTask timerTask;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    private class MyTimerTask extends TimerTask {
        @Override
        public void run() {
            counter++;
            toast.setText("Hello for: " + counter + " time");
            toast.show();
        }
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        timer.purge();
        timerTask.cancel();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        timer = new Timer();
        toast = Toast.makeText(this, "Hello", Toast.LENGTH_SHORT);
        timerTask = new MyTimerTask();
        timer.scheduleAtFixedRate(timerTask, 1000, 3 * 1000);

        return super.onStartCommand(intent, flags, startId);
    }


}
