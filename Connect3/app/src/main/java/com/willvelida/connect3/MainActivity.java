package com.willvelida.connect3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // 0 = yellow, 1 = red
    int activePlayer = 0;

    // Is the game active
    boolean gameIsActive = true;

    // 2 means unplayed
    int[] gameState = {2,2,2,2,2,2,2,2,2};

    // Array of arrays
    // All possible winning positions
    int[][] winningPositions = {{0,1,2},{3,4,5,},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};

    public void dropIn(View view) {

        ImageView counter = (ImageView) view;

        // get the tag of the image we click
        counter.getTag();

        int tappedCounter = Integer.parseInt(counter.getTag().toString());

        if (gameState[tappedCounter] == 2 && gameIsActive) {

            // Set the tapped image to the players counter
            gameState[tappedCounter] = activePlayer;

            // Move iamge off the screen
            counter.setTranslationY(-1000f);

            if (activePlayer == 0) {
                // Set the image resource
                counter.setImageResource(R.drawable.yellow);
                activePlayer = 1;
            } else {
                // Set the image resource
                counter.setImageResource(R.drawable.red);
                activePlayer = 0;
            }

            // Animate it back in again
            counter.animate().translationYBy(1000f).rotation(360).setDuration(300);

            // loop through winning positions and check if game state matches
            for (int[] winningPosition : winningPositions) {
                if (gameState[winningPosition[0]] == gameState[winningPosition[1]] &&
                        gameState[winningPosition[1]] == gameState[winningPosition[2]] &&
                        gameState[winningPosition[0]] != 2) {

                    // disable the game
                    gameIsActive = false;

                    // Red by default
                    String winner = "Red";

                    // Has yellow won!
                    if (gameState[winningPosition[0]] == 0) {
                        winner = "Yellow";
                    }
                    // Someone has won! Make layout appear!
                    TextView winnerMessage = (TextView) findViewById(R.id.winnerMessage);
                    winnerMessage.setText(winner + " has won!");
                    LinearLayout layout = (LinearLayout) findViewById(R.id.playAgainLayout);
                    layout.setVisibility(View.VISIBLE);
                } else {

                    boolean gameIsOver = true;

                    for (int counterState : gameState) {
                        if (counterState == 2) {
                            gameIsOver = false;
                        }
                    }

                    if (gameIsOver) {
                        // Someone has won! Make layout appear!
                        TextView winnerMessage = (TextView) findViewById(R.id.winnerMessage);
                        winnerMessage.setText("It's a draw!");
                        LinearLayout layout = (LinearLayout) findViewById(R.id.playAgainLayout);
                        layout.setVisibility(View.VISIBLE);
                    }
                }
            }
        }
    }

    // Play Again Method
    public void playAgain(View view) {

        gameIsActive = true;

        LinearLayout layout = (LinearLayout) findViewById(R.id.playAgainLayout);
        layout.setVisibility(View.INVISIBLE);

        // 0 = yellow, 1 = red
        int activePlayer = 0;

        for (int i = 0; i < gameState.length; i++) {
            gameState[i] = 2;
        }

        GridLayout gridLayout = (GridLayout) findViewById(R.id.mainGrid);

        for (int i = 0; i < gridLayout.getChildCount(); i++) {
            ((ImageView) gridLayout.getChildAt(i)).setImageResource(0);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
