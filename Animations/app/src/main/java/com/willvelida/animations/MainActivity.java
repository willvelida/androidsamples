package com.willvelida.animations;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatImageView;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    public void fade(View view) {
        // Get an image view
        ImageView unity = (ImageView) findViewById(R.id.unityImage);
        // animate the picture

        unity.animate().translationXBy(1000f).setDuration(2000);
        // Now make London fade in
        //ImageView london = (ImageView) findViewById(R.id.londonImage);
        //london.animate().alpha(1f).setDuration(2000);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Get an image view
        ImageView unity = (ImageView) findViewById(R.id.unityImage);
        // animate the picture

        unity.setTranslationX(-1000f);
    }
}
