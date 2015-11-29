package com.logotet.foolaround;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;

import java.io.IOException;

public class ProgressBarActivity extends AppCompatActivity {
    private Handler handler;
    private ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress_bar);

        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        handler = new Handler(){
            @Override
            public void handleMessage(Message msg) {
                progressBar.setProgress(msg.arg1);
//                if(msg.arg1 == 100)
//                    progressBar.setVisibility(View.INVISIBLE);
            }
        };
        Thread th = new Thread(new MyRunnable());
        th.start();
    }

    class MyRunnable implements  Runnable{
        @Override
        public void run() {
            Message msg = Message.obtain();
            for(int i = 0; i <= 100; i++)
            try {
                msg.arg1 = i;
                handler.handleMessage(msg);
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    progressBar.setVisibility(View.INVISIBLE);
                }
            });
        }
    }



}
