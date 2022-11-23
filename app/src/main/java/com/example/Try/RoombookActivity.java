package com.example.Try;


import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RoombookActivity extends AppCompatActivity {
    DatabaseReference databaseReference;
    String emailPattern= "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.roombook);

        //read data from the edittext and the spinner
        final EditText fullnameR = findViewById(R.id.fullname);
        final EditText phoneR = findViewById(R.id.phone);
        final EditText emailR = findViewById(R.id.email);
        final Spinner locationR = findViewById(R.id.location);
        final Spinner flatsR = findViewById(R.id.flats);
        final Spinner roomsR = findViewById(R.id.norooms);

        //button to submit data to database
        final Button submit = findViewById(R.id.btnroom);
        databaseReference= FirebaseDatabase.getInstance().getReference().child("RoomBooking");

        String[] locations={"Nairobi", "Mombasa", "Kisumu", "Malindi", "Taita taveta", "Nakuru", "Kitui"};
        ArrayAdapter<String> loc=new ArrayAdapter<>(RoombookActivity.this, android.R.layout.simple_spinner_item,locations);
        //aa.add("Select the county");
        loc.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        locationR.setAdapter(loc);

        String[] flatss={"Nairobi_penda", "Mombasa_greenhall", "Kisumu_palez", "Malindi_polik", "Taita taveta_regok", "Nakuru_amaze", "Kitui_pedug"};
        ArrayAdapter<String> fl=new ArrayAdapter<>(RoombookActivity.this, android.R.layout.simple_spinner_item,flatss);
        //aa.add("Select the county");
        fl.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        flatsR.setAdapter(fl);

        String[] roomss={"256", "5", "23", "46", "90", "32", "54","23", "456", "7", "34", "22", "3"};
        ArrayAdapter<String> rm=new ArrayAdapter<>(RoombookActivity.this, android.R.layout.simple_spinner_item,roomss);
        //aa.add("Select the county");
        rm.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        roomsR.setAdapter(rm);


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String fullname = fullnameR.getText().toString();
                final String phone = phoneR.getText().toString();
                final String email= emailR.getText().toString();
                final String location = locationR.getSelectedItem().toString();
                final String flats = flatsR.getSelectedItem().toString();
                final String room = roomsR.getSelectedItem().toString();

                if (fullname.isEmpty() || fullname.length()<10) {
                    fullnameR.setError(" Very short name");
                }
                else if (phone.length()<10 || phone.isEmpty())
                {
                    phoneR.setError("incorrect");
                }
                else if (!email.matches(emailPattern))
                {
                    emailR.setError("Incorrect email format");
                }
                else{
                    RoomBooking roomBooking= new RoomBooking(fullname,phone, email, location, flats, room);
                    databaseReference.push().setValue(roomBooking);
                    Toast.makeText(RoombookActivity.this, "room data entered successfully", Toast.LENGTH_SHORT).show();

                    if (ContextCompat.checkSelfPermission(RoombookActivity.this, Manifest.permission.SEND_SMS)== PackageManager.PERMISSION_GRANTED)
                    {
                        //when persmission is granted
                        SmsManager smsManager= SmsManager.getDefault();
                        smsManager.sendTextMessage(phone, null, "Dear "+fullname+ ", you have booked room " +room+  ", at " +flats+ ". Payment on arrival",null, null);
                        //smsManager.sendTextMessage(phone, null, "Thank you "+fullname+" for visiting our app. Your destination is "+county+ ", reserved for "+type+", registered with "+email+" at a budget of "+budget_level+". We will keep you updated in case of new information. your destination details have been saved successfully",null, null);
                        //smsManager.sendTextMessage(budget_level, null, reserve, null, null);
                        Toast.makeText(getApplicationContext(), "SMS send successfully", Toast.LENGTH_LONG).show();

                    }

                    else
                    {
                        Toast.makeText(getApplicationContext(), "SMS not send", Toast.LENGTH_LONG).show();
                        //ActivityCompat.requestPermissions(DestinationActivity.this, new String[]{Manifest.permission.SEND_SMS}, 100);
                    }

                }
            }
        });


    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode==100 && grantResults.length > 0 && grantResults[0]== PackageManager.PERMISSION_GRANTED)
        {
            Toast.makeText(getApplicationContext(), "Permission granted", Toast.LENGTH_LONG).show();
        }
        else
        {
            Toast.makeText(getApplicationContext(), "Permission denied", Toast.LENGTH_LONG).show();
        }
    }
}

