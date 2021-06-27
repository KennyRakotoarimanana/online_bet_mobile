package com.example.onlinebet.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.onlinebet.R;
import com.example.onlinebet.activities.LoginActivity;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
       // setTheme(R.style.Theme_OnlineBetLauncher);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        showSplashScreen();
    }

    void showSplashScreen() {
        Handler handler = new Handler();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                Intent home = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(home);
            }
        };
        handler.postDelayed(runnable, 2000);
    }
}