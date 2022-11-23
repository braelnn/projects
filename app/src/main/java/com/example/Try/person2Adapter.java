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
public class person2Adapter extends  FirebaseRecyclerAdapter<
        person2, person2Adapter.personssViewholder> {

    public person2Adapter(
            @NonNull FirebaseRecyclerOptions<person2> options)
    {
        super(options);
    }

    // Function to bind the view in Card view(here
    // "person.xml") iwth data in
    // model class(here "person.class")
    @Override
    protected void
    onBindViewHolder(@NonNull personssViewholder holder,
                     int position, @NonNull person2 model)
    {

        // Add firstname from model class (here
        // "person.class")to appropriate view in Card
        // view (here "person.xml")
        holder.type.setText(model.getType());

        // Add lastname from model class (here
        // "person.class")to appropriate view in Card
        // view (here "person.xml")
        holder.budget.setText(model.getBudget());

        // Add age from model class (here
        // "person.class")to appropriate view in Card
        // view (here "person.xml")
        holder.people.setText(model.getPeople());


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
                .inflate(R.layout.person2, parent, false);
        return new person2Adapter.personssViewholder(view);
    }

    // Sub Class to create references of the views in Crad
    // view (here "person.xml")
    class personssViewholder
            extends RecyclerView.ViewHolder {
        TextView type, budget, people, county ;
        public personssViewholder(@NonNull View itemView)
        {
            super(itemView);

           type
                    = itemView.findViewById(R.id.type);
            budget= itemView.findViewById(R.id.budget);
            people = itemView.findViewById(R.id.people);

            county = itemView.findViewById(R.id.county);
        }
    }

}
