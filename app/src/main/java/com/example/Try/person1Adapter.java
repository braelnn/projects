package com.example.Try;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

// FirebaseRecyclerAdapter is a class provided by
// FirebaseUI. it provides functions to bind, adapt and show
// database contents in a Recycler View
public class person1Adapter extends  FirebaseRecyclerAdapter<
        person1, person1Adapter.personssViewholder> {

    public person1Adapter(
            @NonNull FirebaseRecyclerOptions<person1> options)
    {
        super(options);
    }

    // Function to bind the view in Card view(here
    // "person.xml") iwth data in
    // model class(here "person.class")
    @Override
    protected void
    onBindViewHolder(@NonNull personssViewholder holder,
                     int position, @NonNull person1 model)
    {

        // Add firstname from model class (here
        // "person.class")to appropriate view in Card
        // view (here "person.xml")
        holder.health.setText(model.getHealth());

        // Add lastname from model class (here
        // "person.class")to appropriate view in Card
        // view (here "person.xml")
        holder.sec.setText(model.getSec());

        // Add age from model class (here
        // "person.class")to appropriate view in Card
        // view (here "person.xml")
        holder.guide.setText(model.getGuide());
        holder.max.setText(model.getMax());

        holder.county.setText(model.getCounty());
    }

    // Function to tell the class about the Card view (here
    // "person.xml")in
    // which the data will be shown
    @NonNull
    @Override
    public personssViewholder
    onCreateViewHolder(@NonNull ViewGroup parent,
                       int viewType)
    {
        View view
                = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.person1, parent, false);
        return new person1Adapter.personssViewholder(view);
    }

    // Sub Class to create references of the views in Crad
    // view (here "person.xml")
    class personssViewholder
            extends RecyclerView.ViewHolder {
        TextView sec, guide, health, max, county ;
        public personssViewholder(@NonNull View itemView)
        {
            super(itemView);

            sec
                    = itemView.findViewById(R.id.sec);
            guide= itemView.findViewById(R.id.guide);
            health = itemView.findViewById(R.id.health);
            max = itemView.findViewById(R.id.max);
            county = itemView.findViewById(R.id.county);
        }
    }

}
