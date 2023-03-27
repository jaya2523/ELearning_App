package com.example.project_elearning;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class PlayAdapter extends ArrayAdapter<Play> {
    private Context ct;
    private ArrayList<Play> arr;
    public PlayAdapter(@NonNull Context context, int resource, @NonNull List<Play> objects){
        super(context,resource,objects);
        this.ct=context;
        this.arr = new ArrayList<>(objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){
        if(convertView == null){
            LayoutInflater i = (LayoutInflater)ct.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = i.inflate(R.layout.video_list,null);
        }
        if(arr.size()>0){
            Play d = arr.get(position);
            ImageView imgPlay = convertView.findViewById(R.id.imgPlay);
            TextView txtNamePlay = convertView.findViewById(R.id.txtNamePlay);
            imgPlay.setImageResource(d.image);
            txtNamePlay.setText(d.name);
        }
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(parent.getContext(),"clicked",Toast.LENGTH_SHORT).show();
                view.getContext().startActivity(new Intent(ct, VideoActivity.class));
            }
        });
        return convertView;
    }
}
