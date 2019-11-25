package com.example.homework7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view) {
        switch(view.getId()){
            case R.id.dagi:{
                EditText daysDagi = (EditText)findViewById(R.id.days);
                EditText localName = (EditText)findViewById(R.id.localNameOne);
                String day = daysDagi.getText().toString();
                String local = localName.getText().toString();

                Intent intent = new Intent(this, Main2Activity.class);
                intent.putExtra("DAYS", day);
                intent.putExtra("LOCAL", local);
                startActivity(intent);
                break;
            }
            case R.id.mise:{
                EditText localName = (EditText)findViewById(R.id.localNameTwo);
                String local = localName.getText().toString();

                Intent intent = new Intent(this, Main3Activity.class);
                intent.putExtra("LOCAL", local);
                startActivity(intent);
                break;
            }
        }
    }
}
