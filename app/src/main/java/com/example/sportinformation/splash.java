package com.example.sportinformation;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import com.airbnb.lottie.LottieAnimationView;


public class splash extends AppCompatActivity {

    LottieAnimationView lottieAnimationView;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        lottieAnimationView = findViewById(R.id.lottie);

        int splashScreenDuration = 3000; // Durasi splash screen dalam milidetik (misalnya 3000ms = 3 detik)
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                lottieAnimationView.animate().translationY(1400).setDuration(1000).setStartDelay(1000);

                Intent mainIntent = new Intent(splash.this, Login.class);
                startActivity(mainIntent);
                finish();
            }
        }, splashScreenDuration);

    }
}