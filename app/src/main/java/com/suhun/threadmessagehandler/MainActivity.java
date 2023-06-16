package com.suhun.threadmessagehandler;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private String tag = MainActivity.class.getSimpleName();
    private TextView showResult1, getShowResult2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initview();
    }
    private void initview(){
        showResult1 = findViewById(R.id.result1);
        showResult1 = findViewById(R.id.result2);
    }
    public void runThread1Fun(View view){
        MyThread myThread1 = new MyThread("happy", "method1");
        myThread1.start();
    }
    public void runThread2Fun(View view){
        MyThread myThread2 = new MyThread("happy", "method2");
        myThread2.start();
    }
}