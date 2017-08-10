package com.willvelida.timerdemo;

import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Countdown timers!
        new CountDownTimer(10000, 1000) {
            public void onTick(long millisecondsUntilDone) {
                // countdown is counting down
                Log.i("Seconds left", String.valueOf(millisecondsUntilDone / 1000));
            }

            public void onFinish() {
                // counter is finished
                Log.i("Done!", "Countdown timer finished!");
            }
        }.start();

        /*
        // Create a handler
        // allows chunks of code to be run in a delayed way
        final Handler handler = new Handler();
        // Runnables are methods that can be run every x seconds
        Runnable run = new Runnable() {
            @Override
            public void run() {
                // Insert code to be run every second

                Log.i("Runnable has run!", "a second must have passed!");

                handler.postDelayed(this, 1000);
            }
        };

        // Initialize runnable
        handler.post(run);
        */
    }



}
