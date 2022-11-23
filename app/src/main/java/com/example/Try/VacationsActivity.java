package com.example.Try;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

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

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class VacationsActivity extends AppCompatActivity {
    String emailPattern= "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vacations);
        final EditText fullnameT= findViewById(R.id.fullname);
        final EditText emailT= findViewById(R.id.inputEmail);
        final EditText phoneT= findViewById(R.id.inputPhone);
        final Spinner budgetT= findViewById(R.id.budgetlevel);
        final Spinner typeT= findViewById(R.id.type);
        final Spinner genderT = findViewById(R.id.gender);
        final Spinner adultT= findViewById(R.id.adult);
        final Spinner childrenT= findViewById(R.id.children);
        final Spinner countyT = findViewById(R.id.counties);

        final Button submit = findViewById(R.id.btnsubmit);

        databaseReference= FirebaseDatabase.getInstance().getReference().child("Destinations");



        String[] counties={"Laikipia", "Embu", "Kwale", "Murang'a", "Kirinyaga", "Nyeri", "Kiambu", "Migori"};
        ArrayAdapter<String> aa=new ArrayAdapter<>(VacationsActivity.this, android.R.layout.simple_spinner_item,counties);
        //aa.add("Select the county");
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        countyT.setAdapter(aa);

        String[] typees={"Vacations"};
        ArrayAdapter<String> yy=new ArrayAdapter<>(VacationsActivity.this, android.R.layout.simple_spinner_item,typees);
        //aa.add("Select the county");
        yy.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        typeT.setAdapter(yy);

        String[] budgeet={"Ksh 500-4000", "Ksh 5000-10000", "Ksh 10000-15000", "Ksh 15000-20000", "Ksh 20000-25000", "Ksh 25000-30000", "Ksh 40000 and above"};
        ArrayAdapter<String> bb=new ArrayAdapter<>(VacationsActivity.this, android.R.layout.simple_spinner_item,budgeet);
        //bb.add("Select budget level");
        bb.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        budgetT.setAdapter(bb);

        String[] genders={"Female", "Male"};
        ArrayAdapter<String> cc=new ArrayAdapter<>(VacationsActivity.this, android.R.layout.simple_spinner_item,genders);
        //cc.add("Select the gender");
        cc.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        genderT.setAdapter(cc);

        String[] adults={"1", "2", "3", "4", "5", "6", "7","8"};
        ArrayAdapter<String> dd=new ArrayAdapter<>(VacationsActivity.this, android.R.layout.simple_spinner_item,adults);
        //dd.add("Select the gender");
        dd.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adultT.setAdapter(dd);

        String[] child={"1", "2", "3", "4", "5", "6", "7"};
        ArrayAdapter<String> ee=new ArrayAdapter<>(VacationsActivity.this, android.R.layout.simple_spinner_item,child);
        //ee.add("Select the gender");
        ee.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        childrenT.setAdapter(ee);

//        String[] reservation={"GameParks", "Sports", "Restaurants", "Picnic", "Family vacation", "Friends vacation"};
//        ArrayAdapter<String> ff=new ArrayAdapter<>(DestinationActivity.this, android.R.layout.simple_spinner_item,reservation);
//        //ff.add("Type of Reservation");
//        ff.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        reserveT.setAdapter(ff);


//        if (aa.equals("Nairobi")) {
//            String[] nai={"GameParks","Picnic"};
//            ArrayAdapter<String> fff=new ArrayAdapter<>(DestinationActivity.this, android.R.layout.simple_spinner_item,nai);
//            //ff.add("Type of Reservation");
//            fff.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//            reserve.setAdapter(fff);
//        }

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String fullname = fullnameT.getText().toString();
                final String phone= phoneT.getText().toString();
                final String email = emailT.getText().toString();
                final String county = countyT.getSelectedItem().toString();
                final String type = typeT.getSelectedItem().toString();
                final String budget_level = budgetT.getSelectedItem().toString();
                final String gender = genderT.getSelectedItem().toString();
                final String No_of_adult = adultT.getSelectedItem().toString();
                final String No_of_children = childrenT.getSelectedItem().toString();

                if (fullname.isEmpty() || fullname.length()<12)
                {
                    fullnameT.setError("too short");
                }
                else if (phone.length()<10 || phone.isEmpty())
                {
                    phoneT.setError("invalid or too short");
                }
                else if(!email.matches(emailPattern) ||email.isEmpty())
                {
                    emailT.setError("incorrect email");
                }
                else {


                    Destinations destinations = new Destinations(fullname,type, phone, email, county, budget_level, gender, No_of_adult, No_of_children);
                    databaseReference.push().setValue(destinations);


                    //to send messages
                    //check condition
                    if (ContextCompat.checkSelfPermission(VacationsActivity.this, Manifest.permission.SEND_SMS)== PackageManager.PERMISSION_GRANTED)
                    {
                        //when persmission is granted
                        SmsManager smsManager= SmsManager.getDefault();
                        smsManager.sendTextMessage(phone, null, "Dear "+fullname+ ", you have reserved a " +type+  ", at " +county+ ", on a budget of "+budget_level+ "",null, null);
                        //smsManager.sendTextMessage(budget_level, null, reserve, null, null);
                        Toast.makeText(getApplicationContext(), "SMS send successfully", Toast.LENGTH_LONG).show();

                    }

                    else
                    {
                        Toast.makeText(getApplicationContext(), "SMS not send", Toast.LENGTH_LONG).show();
                        //ActivityCompat.requestPermissions(DestinationActivity.this, new String[]{Manifest.permission.SEND_SMS}, 100);
                    }



                }
//                else if(countyTxt.isEmpty() || reserveTxt.isEmpty() || budgetTxt.isEmpty() || genderTxt.isEmpty() ||adultTxt.isEmpty() || childTxt.isEmpty() )
//                {
//                    submit.setError("All fields should be filled");
//                }
//
//                else
//                {
//                    databaseReference.child("Destinations").addListenerForSingleValueEvent(new ValueEventListener() {
//                        @Override
//                        public void onDataChange(@NonNull DataSnapshot snapshot) {
//                            if(snapshot.hasChild(emailTxt)){
//                                Toast.makeText(DestinationActivity.this, "Registration number already exists!!", Toast.LENGTH_SHORT).show();
//                            }
//                            else {
//                                databaseReference.child("Destinations").child(emailTxt).child("fullnames").setValue(fullnameTxt);
////                                databaseReference.child("Destinations").child(emailTxt).child("email").setValue(emailTxt);
//                                databaseReference.child("Destinations").child(emailTxt).child("county").setValue(countyTxt);
//                                databaseReference.child("Destinations").child(emailTxt).child("phone").setValue(phoneTxt);
//                                databaseReference.child("Destinations").child(emailTxt).child("reserve").setValue(reserveTxt);
//                                databaseReference.child("Destinations").child(emailTxt).child("budget").setValue(budgetTxt);
//                                databaseReference.child("Destinations").child(emailTxt).child("gender").setValue(genderTxt);
//                                databaseReference.child("Destinations").child(emailTxt).child("adult").setValue(adultTxt);
//                                databaseReference.child("Destinations").child(emailTxt).child("adult").setValue(childTxt);
//                                Toast.makeText(DestinationActivity.this, "Registration successful", Toast.LENGTH_SHORT).show();
//                                finish();
//
//                            }
//                        }
//
//                        @Override
//                        public void onCancelled(@NonNull DatabaseError error) {
//
//                        }
//                    });
////
//                }


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