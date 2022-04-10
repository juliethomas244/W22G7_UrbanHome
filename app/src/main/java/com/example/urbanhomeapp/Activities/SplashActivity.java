package com.example.urbanhomeapp.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.urbanhomeapp.R;

import java.util.Timer;
import java.util.TimerTask;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                startActivity(
                        new Intent(SplashActivity.this, LoginActivity.class));
            }
        };

        Timer timer = new Timer();
        timer.schedule(timerTask,1000);

    }
}