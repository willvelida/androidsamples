package com.willvelida.higherorlower;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    // This variable is available to the class
    int randomNumber;

    public void guessNumberClick(View view) {

        EditText numberGuess = (EditText) findViewById(R.id.guessNumber);
        int g = Integer.parseInt(numberGuess.getText().toString());

        if (randomNumber > g) {
            makeToast("Higher!");
        } else if (randomNumber < g) {
            makeToast("Lower");
        } else {
            makeToast("That's right! Play again!");
            Random rand = new Random();
            randomNumber = rand.nextInt(20) + 1;
        }
    }

    public void makeToast(String string) {
        Toast.makeText(MainActivity.this, string, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Generate the random number on launch of app
        Random rand = new Random();
        randomNumber = rand.nextInt(20) + 1;
    }
}
