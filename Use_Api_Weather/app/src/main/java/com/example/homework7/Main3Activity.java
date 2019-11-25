package com.example.homework7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Main3Activity extends AppCompatActivity {
    GetXMLTask getTest = new GetXMLTask();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        Intent intent = getIntent();
        String localName = intent.getStringExtra("LOCAL");

        Date currentTime = Calendar.getInstance().getTime();
        SimpleDateFormat year = new SimpleDateFormat("yyyy", Locale.getDefault());
        SimpleDateFormat month = new SimpleDateFormat("MM", Locale.getDefault());
        SimpleDateFormat day = new SimpleDateFormat("dd", Locale.getDefault());

        String push = "http://openapi.seoul.go.kr:8088/666643564870726f34346547437953/xml/DailyAverageAirQuality/1/5/";
        push += year.format(currentTime)+month.format(currentTime)+day.format(currentTime)+"/";
        String encodeStr = "";
        try {
            encodeStr = URLEncoder.encode(localName, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        push += encodeStr;

        getTest.execute(push);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                TextView fifth = (TextView)findViewById(R.id.pm10);
                TextView sixth = (TextView)findViewById(R.id.pm25);
                fifth.setText(getTest.Pm10);
                sixth.setText(getTest.Pm25);
            }
        }, 1000);

    }
}
