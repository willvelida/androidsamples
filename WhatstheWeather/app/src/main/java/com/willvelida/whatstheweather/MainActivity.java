package com.willvelida.whatstheweather;

import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

public class MainActivity extends AppCompatActivity {

    // UI Variables
    EditText cityEditText;
    Button getWeatherButton;
    TextView mainTextView;
    TextView descriptionTextView;

    String cityName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cityEditText = (EditText) findViewById(R.id.cityEditText);
        getWeatherButton = (Button) findViewById(R.id.getWeatherButton);
        mainTextView = (TextView) findViewById(R.id.mainWeatherTextView);
        descriptionTextView = (TextView) findViewById(R.id.descriptionTextView);
    }

    public void getWeather(View view) {

        InputMethodManager mgr = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        mgr.hideSoftInputFromWindow(cityEditText.getWindowToken(), 0);

        // encode spaces as url
        try {
            String encodedCityName = URLEncoder.encode(cityEditText.getText().toString(), "UTF-8");
            DownloadTask task = new DownloadTask();
            task.execute("http://api.openweathermap.org/data/2.5/weather?q=" + encodedCityName + "&appid=7a2fe1a43af445d3165a735f8c22c249");
        } catch (UnsupportedEncodingException e) {
            Toast.makeText(getApplicationContext(), "Could not find weather", Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }



        // Log.i("City Name", cityEditText.getText().toString());
    }

    public class DownloadTask extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... urls) {
            // Initialize the result
            String result = "";
            // Create URL variable
            URL url;
            // Create HTTP URL Connection
            HttpURLConnection urlConnection = null;

            try {
                // Set url to our url
                url = new URL(urls[0]);
                // Open the connection
                urlConnection = (HttpURLConnection) url.openConnection();
                // Create new input stream
                InputStream in = urlConnection.getInputStream();
                // Create new Input Stream Reader
                InputStreamReader reader = new InputStreamReader(in);
                // create data variable
                int data = reader.read();
                while (data != -1) {
                    char current = (char) data;
                    result += current;
                    data = reader.read();
                }
                // Once we have read the data, return the result
                return result;
            } catch (Exception e) {
                Toast.makeText(getApplicationContext(), "Could not find weather", Toast.LENGTH_LONG).show();
            }
            return null;
        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);

            try {

                String message = "";
                // Create a JSON Object
                JSONObject jsonObject = new JSONObject(result);
                // Create a string for weather info
                String weatherInfo = jsonObject.getString("weather");
                // Create a JSON array for the weatherInfo
                JSONArray arr = new JSONArray(weatherInfo);

                for (int i = 0; i < arr.length(); i++) {
                    JSONObject jsonPart = arr.getJSONObject(i);

                    String main = "";
                    String desc = "";

                    main = jsonPart.getString("main");
                    desc = jsonPart.getString("description");

                    if (main != "" & desc != "") {
                        //message += main + ":" + desc + "\r\n";
                        mainTextView.setText(main);
                        descriptionTextView.setText(desc);
                    }

                }

                /*if (message != "") {
                    mainTextView.setText(message);
                }*/
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
