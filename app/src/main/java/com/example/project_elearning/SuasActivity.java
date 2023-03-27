package com.example.project_elearning;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Locale;

public class SuasActivity extends AppCompatActivity {
    TextToSpeech t1;
    ImageView locate;
    Button skip;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suas);
        getSupportActionBar().hide();
        skip = (Button) findViewById(R.id.button2);
        locate = (ImageView) findViewById(R.id.imageView7);

        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
                t1.stop();
                t1.shutdown();
            }
        });
        t1=new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status != TextToSpeech.ERROR) {
                    t1.setLanguage(Locale.UK);
                    t1.setSpeechRate(0.85f);
                    Toast.makeText(getApplicationContext(),"← You may \nsee the location",Toast.LENGTH_SHORT).show();
                    t1.speak("Welcome to Symbi ELearning App this is the distance learning initiative taken by Symbiosis Foundation It is India's First Skill Based University ", TextToSpeech.QUEUE_FLUSH, null);
                }
            }
        });
    }
    public void map(View view){
        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:22.752656580171724, 75.79569956775447"));
        startActivity(i);
    }
}