package com.willvelida.numbershapes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    class Number {

        int number;

        public boolean isSquare() {

            double squareRoot = Math.sqrt(number);

            if (squareRoot == Math.floor(squareRoot)) {

                return true;
            } else {

                return false;

            }

        }

        public boolean isTriangular() {

            int x = 1;

            int triangularNumber = 1;

            while (triangularNumber < number) {

                x++;
                triangularNumber = triangularNumber + x;
            }

            if (triangularNumber == number) {
                return true;
            } else {
                return false;
            }

        }


    }

    public void testNumber(View view) {

        // create a new EditText variable to connect to UI
        EditText usersNumber = (EditText) findViewById(R.id.usersNumber);

        // Create a new instance of number
        Number myNumber  = new Number();

        // parse the edit text value to int
        myNumber.number = Integer.parseInt(usersNumber.getText().toString());

        // initialize a new String message
        String message = "";

        // test to see if the user has entered anything
        if (usersNumber.getText().toString().isEmpty()) {
            message = "Please enter a number!";
        }

        // Main logic to determine whether number is square, tri, both or neither
        if (myNumber.isSquare()) {
            if (myNumber.isTriangular()) {
                message = myNumber.number + " is both triangular and square!";
            } else {
                message = myNumber.number + " is a square number, but not a triangular.";
            }
        } else {
            if (myNumber.isTriangular()) {
                message = myNumber.number + " is a triangular number, but not a square!";
            } else {
                message = myNumber.number + " is neither square or triangular.";
            }
        }

        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
