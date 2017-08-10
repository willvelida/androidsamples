package com.willvelida.sounddemo;

import android.content.Context;
import android.media.AudioManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.media.MediaPlayer;
import android.util.Log;
import android.view.View;
import android.widget.SeekBar;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    // Create the media player for the sound
    MediaPlayer mPlayer;
    // Create AudioManager
    AudioManager audioManager;

    // Play the sound
    public void playSound(View view) {
        // start the media
        mPlayer.start();
    }

    // Pause the sound
    public void pauseSound(View view) {
        // pause the media
        mPlayer.pause();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // say what we want our media player to be
        mPlayer = MediaPlayer.create(this, R.raw.fart);
        // AudioManager reference to our system.
        audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        // Maximum volume
        int maxVolume = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        // Current volume
        int currentVolume = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);

        SeekBar volumeControl = (SeekBar) findViewById(R.id.seekBar);
        // Set the maximum volume of the phone
        volumeControl.setMax(maxVolume);
        // Set the current value
        volumeControl.setProgress(currentVolume);

        volumeControl.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {



                // Change the volume
                audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, i, 0);

            }
        });

        // AUDIO LENGTH SEEKBAR WORK
        final SeekBar audioLength = (SeekBar) findViewById(R.id.audioLengthSeekBar);
        // Set the maximum length of the file
        audioLength.setMax(mPlayer.getDuration());

        // Create a timer
        new Timer().scheduleAtFixedRate(new TimerTask() {
            @Override
            // When we run it, we get the progress of the sound file
            public void run() {
                audioLength.setProgress(mPlayer.getCurrentPosition());
            }
        }, 0, 100);

        audioLength.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                mPlayer.seekTo(i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                mPlayer.pause();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                mPlayer.start();
            }
        });
    }
}
