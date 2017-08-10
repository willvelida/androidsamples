package com.willvelida.eggtimer;

import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // Define SeekBar
    SeekBar timerSeekBar;
    // Define TextView
    TextView timerTextView;
    // Define Button
    Button controllerButton;
    // Is the counter active
    Boolean counterIsActive = false;
    // Create countdown timer
    CountDownTimer countDownTimer;

    public void resetTimer() {
        // Reset the timer to 30 seconds
        timerTextView.setText("0:30");
        // Set the seekbar value to 30 seconds
        timerSeekBar.setProgress(30);
        // Cancel the countdown
        countDownTimer.cancel();
        // Re enable seekbar
        timerSeekBar.setEnabled(true);
        // Set counter to false
        counterIsActive = false;
        // Button text reset to Go
        controllerButton.setText("Go!");
    }

    public void updateTimer(int secondsLeft) {
        // Take the number, divide it by 60 and round it up
        int minutes = (int) secondsLeft / 60;
        int seconds = secondsLeft - minutes * 60;

        // Add the extra 0
        String secondString = Integer.toString(seconds);

        if (seconds <= 9){
            secondString = "0" + secondString;
        }

        // update timer text
        timerTextView.setText(Integer.toString(minutes) + ":" + secondString);
    }

    public void controlTimer(View view) {

        // if the counter is not active
        if (counterIsActive == false) {

            //counter is now active!
            counterIsActive = true;

            // disable seekbar
            timerSeekBar.setEnabled(false);
            // Set the text of button to Stop
            controllerButton.setText("Stop");

            // Create a new timer
            countDownTimer = new CountDownTimer(timerSeekBar.getProgress() * 1000 + 100, 1000) {

                @Override
                public void onTick(long l) {
                    // update value of timer
                    updateTimer((int) l / 1000);
                }

                @Override
                public void onFinish() {
                    resetTimer();
                    // Play the airhorn sound
                    MediaPlayer mPlayer = MediaPlayer.create(getApplicationContext(), R.raw.airhorn);
                    mPlayer.start();
                }
            }.start();
        } else {
            resetTimer();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find SeekBar
        timerSeekBar = (SeekBar) findViewById(R.id.timerSeekBar);
        // Find text view
        timerTextView = (TextView) findViewById(R.id.timerTextView);
        // Find Button
        controllerButton = (Button) findViewById(R.id.controllerButton);

        // Set the max value of seekbar
        timerSeekBar.setMax(600);
        // Set current progress of 30 seconds
        timerSeekBar.setProgress(30);

        // seek bar methods
        timerSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                // update timer with value of i
                updateTimer(i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}
