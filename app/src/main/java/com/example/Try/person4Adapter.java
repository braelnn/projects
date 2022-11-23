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
public class person4Adapter extends  FirebaseRecyclerAdapter<
        person4, person4Adapter.personssViewholder> {

    public person4Adapter(
            @NonNull FirebaseRecyclerOptions<person4> options)
    {
        super(options);
    }

    // Function to bind the view in Card view(here
    // "person.xml") iwth data in
    // model class(here "person.class")
    @Override
    protected void
    onBindViewHolder(@NonNull personssViewholder holder,
                     int position, @NonNull person4 model)
    {

        // Add firstname from model class (here
        // "person.class")to appropriate view in Card
        // view (here "person.xml")
        holder.phone.setText(model.getPhone());

        // Add lastname from model class (here
        // "person.class")to appropriate view in Card
        // view (here "person.xml")
        holder.county.setText(model.getCounty());

        // Add age from model class (here
        // "person.class")to appropriate view in Card
        // view (here "person.xml")

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
                .inflate(R.layout.person4, parent, false);
        return new person4Adapter.personssViewholder(view);
    }

    // Sub Class to create references of the views in Crad
    // view (here "person.xml")
    class personssViewholder
            extends RecyclerView.ViewHolder {
        TextView phone, county ;
        public personssViewholder(@NonNull View itemView)
        {
            super(itemView);

            phone
                    = itemView.findViewById(R.id.phone);


            county = itemView.findViewById(R.id.county);
        }
    }

}
