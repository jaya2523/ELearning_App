package com.example.project_elearning;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class DashboardActivity extends AppCompatActivity {
    TextToSpeech t1;
    private ViewPager viewPager,viewPager2;
    private MyAdapter myAdapter1;
    TextView textView;
    //    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        Intent intent=getIntent();
        String toSpeak =intent.getStringExtra("send") ;
        t1=new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status != TextToSpeech.ERROR) {
                    t1.setLanguage(Locale.US);
                    t1.setSpeechRate(0.85f);
                    Toast.makeText(getApplicationContext(), toSpeak,Toast.LENGTH_SHORT).show();
                    t1.speak("Hello,\n" + toSpeak, TextToSpeech.QUEUE_FLUSH, null);
                }
            }
        });
        this.getSupportActionBar().hide();
        textView=findViewById(R.id.textView1);
        textView.setText("Hello "+toSpeak);
        //init actionbar
        viewPager=findViewById(R.id.viewPager1);
        List<Integer> imageList1=new ArrayList<>();
        imageList1.add(R.drawable.ds);
        imageList1.add(R.drawable.wd);
        imageList1.add(R.drawable.ai);

        List<Integer> imageList2=new ArrayList<>();
        imageList2.add(R.drawable.cn);
        imageList2.add(R.drawable.cs);
        imageList2.add(R.drawable.mm);
        myAdapter1=new MyAdapter(imageList1,imageList2,getApplicationContext());
        viewPager.setAdapter(myAdapter1);

        //set view pager change listner
        viewPager2=findViewById(R.id.viewPager2);
        List<Integer> imageList3=new ArrayList<>();
        imageList3.add(R.drawable.mad);
        imageList3.add(R.drawable.iot);
        imageList3.add(R.drawable.cc);
        List<Integer> imageList4=new ArrayList<>();
        imageList4.add(R.drawable.bc);
        imageList4.add(R.drawable.wd);
        imageList4.add(R.drawable.cs);
        myAdapter1=new MyAdapter(imageList3,imageList4,getApplicationContext());
        viewPager2.setAdapter(myAdapter1);
    }
}