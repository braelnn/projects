package com.example.Try;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddroomActivity extends AppCompatActivity {
    DatabaseReference databaseReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addroom);

        final EditText locationT= findViewById(R.id.location);
        final EditText flatsT= findViewById(R.id.flats);
        final EditText roomsT= findViewById(R.id.norooms);
        final Button addroom=findViewById(R.id.btnAddroom);
        databaseReference= FirebaseDatabase.getInstance().getReference().child("AddRoom");

        addroom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String location = locationT.getText().toString();
                final String apartment = flatsT.getText().toString();
                final String roomnumber = roomsT.getText().toString();

                AddRoom addRoom = new AddRoom(location, apartment, roomnumber);
                databaseReference.push().setValue(addRoom);
                Toast.makeText(AddroomActivity.this, "room added successfully", Toast.LENGTH_SHORT).show();
            }
        });


    }
}