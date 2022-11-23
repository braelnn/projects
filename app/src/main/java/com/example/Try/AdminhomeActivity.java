package com.example.Try;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class AdminhomeActivity extends AppCompatActivity {
    Button add, del, info, bud, repo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.adminhome);

        add= findViewById(R.id.addroom);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent a= new Intent(AdminhomeActivity.this, AddroomActivity.class);
                startActivity(a);
            }
        });
        del= findViewById(R.id.btndel);
        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ab= new Intent(AdminhomeActivity.this, TradestinationdetailsActivity.class);
                startActivity(ab);
            }
        });
        info= findViewById(R.id.btnview);
        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ac= new Intent(AdminhomeActivity.this, TravellersinfoActivity.class);
                startActivity(ac);
            }
        });
        bud= findViewById(R.id.btnbud);
        bud.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ac= new Intent(AdminhomeActivity.this, BudgetsActivity.class);
                startActivity(ac);
            }
        });
        repo= findViewById(R.id.btnreports);
        repo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ac= new Intent(AdminhomeActivity.this, ReportsActivity.class);
                startActivity(ac);
            }
        });
    }
}