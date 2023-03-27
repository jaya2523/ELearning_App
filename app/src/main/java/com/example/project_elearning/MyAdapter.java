package com.example.project_elearning;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import java.util.List;

public class MyAdapter extends PagerAdapter {
    List<Integer> list1,list2;
    Context context;
    public MyAdapter(List<Integer> list1, List<Integer> list2, Context context) {
        this.list1 = list1;
        this.list2 = list2;
        this.context=context;
    }
    @Override
    public int getCount() {
        return list1.size();
        //return size of items in list
    }
    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }
    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        //inflate layout card_item.xml

        View view = LayoutInflater.from(container.getContext()).inflate(R.layout.card_item, container, false);
        ImageView imageView=view.findViewById(R.id.banner1);
        ImageView imageView2=view.findViewById(R.id.banner2);
        imageView.setImageResource(list1.get(position));
        imageView2.setImageResource(list2.get(position));
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(position==0) {
                    Intent intent = new Intent(context, VideoListActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(intent);
                }
                if(position==1 && position==2){
                    Toast.makeText(container.getContext(), "No Video List Found", Toast.LENGTH_SHORT).show();
                }
            }
        });
        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(position==0) {
                    Intent intent = new Intent(context, VideoListActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(intent);
                }
                if(position==1 && position==2){
                    Toast.makeText(container.getContext(), "No Video List Found", Toast.LENGTH_SHORT).show();
                }
            }
        });
        //handle card click
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(container.getContext(), "Clicked", Toast.LENGTH_SHORT).show();
            }
        });
        //add view to container
        container.addView(view, position);
        return view;
    }
    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
