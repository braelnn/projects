package com.example.Try;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {
    ImageView des, sprts, vac, hike, pic, repo, stat;
    ImageView room;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);

        des=(ImageView) findViewById(R.id.destiny);
        des.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(HomeActivity.this,DestinationActivity.class);
                startActivity(intent);
            }
        });
        sprts=(ImageView) findViewById(R.id.sports);
        sprts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(HomeActivity.this,SportsActivity.class);
                startActivity(intent);
            }
        });
        vac=(ImageView) findViewById(R.id.vacations);
        vac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(HomeActivity.this,VacationsActivity.class);
                startActivity(intent);
            }
        });
        hike=(ImageView) findViewById(R.id.hikes);
        hike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(HomeActivity.this,MountainhikeActivity.class);
                startActivity(intent);
            }
        });
        pic=(ImageView) findViewById(R.id.picnic);
        pic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(HomeActivity.this,PicnicActivity.class);
                startActivity(intent);
            }
        });
        room=(ImageView) findViewById(R.id.roombook);
        room.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(HomeActivity.this,RoombookActivity.class);
                startActivity(intent);
            }
        });
        repo = (ImageView) findViewById(R.id.adv);
        repo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(HomeActivity.this,ReporthomeActivity.class);
                startActivity(intent);
            }
        });
        stat = (ImageView) findViewById(R.id.status);
        stat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(HomeActivity.this,StatusActivity.class);
                startActivity(intent);
            }
        });
    }
}