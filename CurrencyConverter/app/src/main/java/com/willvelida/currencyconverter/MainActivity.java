package com.willvelida.currencyconverter;

import android.renderscript.Double2;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public void getCurrency(View view) {

        // Get the currency value from the user
        EditText myCurrency = (EditText) findViewById(R.id.currencyText);

        // Convert the value into dollars
        double dollarValue = Double.parseDouble(myCurrency.getText().toString());
        double convertToDollar = dollarValue * 1.31;

        // Show the converted value in the toast
        Toast.makeText(MainActivity.this, "$" + String.valueOf(convertToDollar), Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
