package com.example.looperthread;

import static com.example.looperthread.ExampleHandler.TASK_A;
import static com.example.looperthread.ExampleHandler.TASK_B;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private ExampleLooperThread exampleLooperThread = new ExampleLooperThread();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void startThread(View view) {
        exampleLooperThread.start();
    }

    public void stopThread(View view) {
        exampleLooperThread.looper.quit();
    }

    public void taskA(View view) {

        Message message = Message.obtain();
        message.what = TASK_A;
        exampleLooperThread.handler.sendMessage(message);


//        Handler threadHandler = new Handler(exampleLooperThread.looper);
//        threadHandler.post(new Runnable() {
//            @Override
//            public void run() {
//                for (int i = 0; i < 5; i++) {
//                    Log.d(TAG, "run: "+i +" " + Thread.currentThread().getName());
//                    SystemClock.sleep(1000);
//                }
//            }
//        });
    }

    public void taskB(View view) {
        Message message = Message.obtain();
        message.what = TASK_B;
        exampleLooperThread.handler.sendMessage(message);
    }
}