package com.example.project_elearning;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ImageView image = (ImageView) findViewById(R.id.imageView);
        TextView textView=(TextView)findViewById(R.id.textView);
        TextView textView2=(TextView)findViewById(R.id.textView2);
        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.top_animation);
        image.startAnimation(animation);
        Animation animation2 = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.bottom_animation);
        textView.startAnimation(animation2);
        Animation animation3 = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.bottom_animation);
        textView2.startAnimation(animation3);
        Timer timer=new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                startActivity(new Intent(SplashActivity.this,SuasActivity.class));
            }
        },3000);
    }
}