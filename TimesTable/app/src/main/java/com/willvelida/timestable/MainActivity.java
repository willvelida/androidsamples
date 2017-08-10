package com.willvelida.timestable;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    // ListView
    ListView timesTableListView;

    public void generateTimesTable(int timesTable) {
        // Display our results as a ArrayList of Strings
        ArrayList<String> timesTableContent = new ArrayList<String>();

        // For loop for 10 times each value of timesTable
        for (int i = 1; i <=10; i++) {
            // add a item to timesTableContent
            timesTableContent.add(Integer.toString(i * timesTable));
        }

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, timesTableContent);

        timesTableListView.setAdapter(arrayAdapter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Seek Bar
        final SeekBar timesTableSeekBar = (SeekBar) findViewById(R.id.timesTableSeekBar);
        // Set the value in the OnCreate method
        timesTableListView = (ListView) findViewById(R.id.timesTableListView);
        // Maximum value of SeekBar
        timesTableSeekBar.setMax(20);
        // Initial value of SeekBar onCreate
        timesTableSeekBar.setProgress(10);
        // Method implementation for SeekBar
        timesTableSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){

            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                // Set minimum value of SeekBar
                int min = 1;
                int timesTable;
                if (i < min) {
                    timesTable = min;
                    // Set SeekBar value to 1
                    timesTableSeekBar.setProgress(min);
                } else {
                    timesTable = i;
                }

                // generate the times table with the value of the SeekBar
                generateTimesTable(timesTable);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        // Set the initial value of the SeekBar to 10
        generateTimesTable(10);

    }
}
