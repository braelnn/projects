package com.example.Try;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class ReportsActivity extends AppCompatActivity {
    Button mvc, pre, mbl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reports);

       mvc= findViewById(R.id.mvc);
        mvc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent a= new Intent(ReportsActivity.this, MostvisitedcountyActivity.class);
                startActivity(a);
            }
        });
        pre= findViewById(R.id.pre);
        pre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent a= new Intent(ReportsActivity.this, PreferredreservationActivity.class);
                startActivity(a);
            }
        });
        mbl= findViewById(R.id.mbl);
        mbl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent a= new Intent(ReportsActivity.this, MostbudgetlevelActivity.class);
                startActivity(a);
            }
        });
    }
}