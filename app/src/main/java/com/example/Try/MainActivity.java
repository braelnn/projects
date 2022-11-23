package com.example.Try;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ViewPager2 viewPager2;
    ArrayList<viewpageritem> viewPagerItemArrayList;

    public Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button=(Button) findViewById(R.id.next);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(MainActivity.this,FrontActivity.class);
                startActivity(intent);
            }
        });





        viewPager2= findViewById(R.id.viewpager);
        int[] images= {R.drawable.wildlife, R.drawable.recreation, R.drawable.mountain};
        String[] heading= {"wildlife","recreation","mountain"};
        String[] desc= {getString(R.string.a_desc),getString(R.string.b_desc),getString(R.string.c_desc)};

        viewPagerItemArrayList= new ArrayList<>();
        for(int i=0; i<images.length; i++){
            viewpageritem viewpageritem= new viewpageritem(images[i],heading[i],desc[i]);
            viewPagerItemArrayList.add(viewpageritem);
        }
        VPAdapter vpadapter= new VPAdapter(viewPagerItemArrayList);
        viewPager2.setAdapter(vpadapter);
        viewPager2.setClipToPadding(false);
        viewPager2.setClipChildren(false);
        viewPager2.setOffscreenPageLimit(2);
        viewPager2.getChildAt(0).setOverScrollMode(View.OVER_SCROLL_NEVER);
    }


}