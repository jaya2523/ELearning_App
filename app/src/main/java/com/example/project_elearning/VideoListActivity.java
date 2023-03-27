package com.example.project_elearning;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class VideoListActivity extends AppCompatActivity {
    ListView lsvPlay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_list);
        lsvPlay = findViewById(R.id.lsvPlay);
        ArrayList<Play> arr = new ArrayList<>();

        arr.add(new Play(R.drawable.playbtn, "Module 1"));
        arr.add(new Play(R.drawable.playbtn, "Module 2"));
        arr.add(new Play(R.drawable.playbtn, "Module 3"));
        arr.add(new Play(R.drawable.playbtn, "Module 4"));
        arr.add(new Play(R.drawable.playbtn, "Module 5"));
        arr.add(new Play(R.drawable.playbtn, "Module 6"));
        arr.add(new Play(R.drawable.playbtn, "Module 7"));
        arr.add(new Play(R.drawable.playbtn, "Module 8"));
        arr.add(new Play(R.drawable.playbtn, "Module 9"));
        arr.add(new Play(R.drawable.playbtn, "Module 10"));
        arr.add(new Play(R.drawable.playbtn, "Module 11"));

        PlayAdapter adapter = new PlayAdapter(this,0,arr);
        lsvPlay.setAdapter(adapter);

        lsvPlay.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(i==0){
                    Intent intent=new Intent(VideoListActivity.this,VideoActivity.class);
                    startActivity(intent);
                }
                if(i==1){
                    Toast.makeText(VideoListActivity.this,"Sorry no video", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}