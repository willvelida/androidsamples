package com.willvelida.videodemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewDebug;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Get the video view
        VideoView videoView = (VideoView) findViewById(R.id.videoView);

        // Assign the video to it.
        // If you have a hosted video, you can set it as the video path
        videoView.setVideoPath("android.resource://" + getPackageName() + "/" + R.raw.video);

        // Add controls to the video
        MediaController mediaController = new MediaController(this);

        // Attach media controller to video
        mediaController.setAnchorView(videoView);

        videoView.setMediaController(mediaController);

        // Starts the video on create
        videoView.start();
    }
}
