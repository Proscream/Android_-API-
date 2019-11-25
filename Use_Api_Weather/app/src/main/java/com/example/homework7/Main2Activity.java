package com.example.homework7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLEncoder;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class Main2Activity extends AppCompatActivity {
    GetXMLTask getTest = new GetXMLTask();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent intent = getIntent();
        String push = "http://openapi.seoul.go.kr:8088/666643564870726f34346547437953/xml/DailyAverageAirQuality/1/5/";
        push += intent.getStringExtra("DAYS");
        push+="/";
        String hangeul = intent.getStringExtra("LOCAL");
        String encodeStr = "";
        try {
            encodeStr = URLEncoder.encode(hangeul, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        push += encodeStr;

        getTest.execute(push);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                TextView first =  (TextView)findViewById(R.id.o2n);
                TextView second = (TextView)findViewById(R.id.o3);
                TextView third = (TextView)findViewById(R.id.co);
                TextView fourth = (TextView)findViewById(R.id.so2);
                TextView fifth = (TextView)findViewById(R.id.pm10);
                TextView sixth = (TextView)findViewById(R.id.pm25);
                first.setText(getTest.No2);
                second.setText(getTest.O3);
                third.setText(getTest.Co);
                fourth.setText(getTest.So2);
                fifth.setText(getTest.Pm10);
                sixth.setText(getTest.Pm25);
            }
        }, 1000);
    }

}