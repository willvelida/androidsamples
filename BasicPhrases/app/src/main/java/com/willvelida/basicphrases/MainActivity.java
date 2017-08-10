package com.willvelida.basicphrases;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    public void buttonTapped(View view) {

        int id = view.getId();
        String ourId = "";

        ourId = view.getResources().getResourceEntryName(id);

        // We need 3 things. The id of the button, the directory and the package
        int resourceId = getResources().getIdentifier(ourId, "raw", "com.willvelida.basicphrases");

        // Create a media player using this button with this resource
        MediaPlayer mPlayer = MediaPlayer.create(this, resourceId);
        mPlayer.start();

        // Make sure the buttons work!
        Log.i("Button Tapped", ourId);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
