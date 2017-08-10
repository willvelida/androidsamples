package com.willvelida.textfielddemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public void clickLogin (View view) {
        // Get the username text field
        EditText usernameText = (EditText) findViewById(R.id.usernameTextField);
        // Get the password text field
        EditText passwordText = (EditText) findViewById(R.id.passwordTextField);

        // Log the values to the console
        Log.i("Info", "Username: " + usernameText.getText().toString() + " Password: " + passwordText.getText().toString());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
