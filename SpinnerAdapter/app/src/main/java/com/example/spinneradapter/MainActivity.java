package com.example.spinneradapter;

import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ProgressBar;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Spinner
        Spinner spinner = findViewById(R.id.spinner);

        String[] datas = getResources().getStringArray(R.array.spinner_array);

        ArrayAdapter<String> aa = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, datas);
        aa.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(aa);

        //AutoCompleteTextView
        AutoCompleteTextView autoCompleteTextView = findViewById(R.id.auto);
        String[] autoDatas = getResources().getStringArray(R.array.auto_array);
        ArrayAdapter<String> autoAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, autoDatas);

        autoCompleteTextView.setAdapter(autoAdapter);

        //Progress
        progressBar = findViewById(R.id.progress);
        ProgressThread thread = new ProgressThread();
        thread.start();
    }

    class ProgressThread extends Thread{
        @Override
        public void run() {
            for(int i=0; i<10; i++){
                SystemClock.sleep(1000);
                progressBar.incrementProgressBy(10);
                progressBar.incrementSecondaryProgressBy(15);
            }
        }
    }
}
