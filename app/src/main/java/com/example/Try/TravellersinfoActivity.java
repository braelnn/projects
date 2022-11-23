package com.example.Try;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class TravellersinfoActivity extends AppCompatActivity {
    DatabaseReference databaseReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.travellersinfo);

        final EditText securityT= findViewById(R.id.sec);
        final EditText healthT= findViewById(R.id.health);
        final EditText guideT= findViewById(R.id.guide);
        final Spinner countyT= findViewById(R.id.county);
        final Spinner maxT= findViewById(R.id.max);
        final Button submit= findViewById(R.id.btnsubmit);
        databaseReference= FirebaseDatabase.getInstance().getReference().child("hea & sec");

        String[] counties={"Nairobi", "Mombasa", "Kilifi", "Kwale", "Homabay", "Machakos", "Meru", "Embu", "Kisii", "Kisumu", "Malindi", "Taita taveta", "Nakuru", "Kitui"};
        ArrayAdapter<String> aa=new ArrayAdapter<>(TravellersinfoActivity.this, android.R.layout.simple_spinner_item,counties);
        //aa.add("Select the county");
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        countyT.setAdapter(aa);

        String[] people={"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15"};
        ArrayAdapter<String> yy=new ArrayAdapter<>(TravellersinfoActivity.this, android.R.layout.simple_spinner_item,people);
        //aa.add("Select the county");
        yy.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        maxT.setAdapter(yy);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String sec = securityT.getText().toString();
                final String health= healthT.getText().toString();
                final String guide = guideT.getText().toString();
                final String county = countyT.getSelectedItem().toString();
                final String max = maxT.getSelectedItem().toString();


                Travelinfo travelinfo = new Travelinfo(sec, health,guide, county, max);
                databaseReference.push().setValue(travelinfo);
                Toast.makeText(TravellersinfoActivity.this, "data added successfully", Toast.LENGTH_SHORT).show();
                Intent ac= new Intent(TravellersinfoActivity.this, AdminhomeActivity.class);
                startActivity(ac);
            }
        });


    }
}