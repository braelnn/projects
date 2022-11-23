package com.example.Try;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class BudgetsActivity extends AppCompatActivity {
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.budgets);

        final Spinner countyT= findViewById(R.id.county);
        final Spinner typeT= findViewById(R.id.type);
        final Spinner budgetT = findViewById(R.id.budget);
        final Spinner peopleT= findViewById(R.id.people);
        final Button submit = findViewById(R.id.btnadd);

        databaseReference= FirebaseDatabase.getInstance().getReference().child("Budgets");


        String[] counties={"Nairobi", "Kilifi", "Kwale", "Busia", "Kericho", "Wajir", "Makueni", "Mombasa", "Kisumu", "Malindi", "Taita taveta", "Nakuru", "Kitui"};
        ArrayAdapter<String> aa=new ArrayAdapter<>(BudgetsActivity.this, android.R.layout.simple_spinner_item,counties);
        //aa.add("Select the county");
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        countyT.setAdapter(aa);

        String[] typees={"Game Parks", "Sports", "Picnic", "Mountain Hikes"};
        ArrayAdapter<String> yy=new ArrayAdapter<>(BudgetsActivity.this, android.R.layout.simple_spinner_item,typees);
        //aa.add("Select the county");
        yy.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        typeT.setAdapter(yy);

        String[] budgeet={"Ksh 500", "Ksh 4000", "Ksh 2500", "Ksh 10000", "Ksh 15000", "Ksh 20000", "Ksh 25000", "Ksh 28000", "Ksh 22500","Ksh 30000", "Ksh 40000", "Ksh 50000"};
        ArrayAdapter<String> bb=new ArrayAdapter<>(BudgetsActivity.this, android.R.layout.simple_spinner_item,budgeet);
        //bb.add("Select budget level");
        bb.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        budgetT.setAdapter(bb);

        String[] peoples={"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15"};
        ArrayAdapter<String> cc=new ArrayAdapter<>(BudgetsActivity.this, android.R.layout.simple_spinner_item,peoples);
        //cc.add("Select the gender");
        cc.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        peopleT.setAdapter(cc);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String county = countyT.getSelectedItem().toString();
                final String type = typeT.getSelectedItem().toString();
                final String budget = budgetT.getSelectedItem().toString();
                final String people = peopleT.getSelectedItem().toString();


                Budgets budgets = new Budgets(people, county, type, budget);
                databaseReference.push().setValue(budgets);

                Toast.makeText(BudgetsActivity.this, "data added successfully", Toast.LENGTH_SHORT).show();
                Intent ac= new Intent(BudgetsActivity.this, AdminhomeActivity.class);
                startActivity(ac);
            }
        });
    }
}