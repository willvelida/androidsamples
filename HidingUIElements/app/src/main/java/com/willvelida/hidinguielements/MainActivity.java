package com.willvelida.hidinguielements;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // Get Text View
    TextView textView;
    // Get Show Button
    Button showButton;
    // Get Hide button
    Button hideButton;

    // show the text view
    public void showText(View view) {
        textView.setVisibility(View.VISIBLE);
    }

    // hide the text view
    public void hideText(View view) {
        textView.setVisibility(View.INVISIBLE);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // When the app is created, set the buttons their references!
        textView = (TextView) findViewById(R.id.textView);
        showButton = (Button) findViewById(R.id.showButton);
        hideButton = (Button) findViewById(R.id.hideButton);
    }
}
