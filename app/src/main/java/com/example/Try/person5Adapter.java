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
public class person5Adapter extends  FirebaseRecyclerAdapter<
        person5, person5Adapter.personssViewholder> {

    public person5Adapter(
            @NonNull FirebaseRecyclerOptions<person5> options)
    {
        super(options);
    }

    // Function to bind the view in Card view(here
    // "person.xml") iwth data in
    // model class(here "person.class")
    @Override
    protected void
    onBindViewHolder(@NonNull personssViewholder holder,
                     int position, @NonNull person5 model)
    {

        // Add firstname from model class (here
        // "person.class")to appropriate view in Card
        // view (here "person.xml")
        holder.budget_level.setText(model.getBudget_level());

        // Add lastname from model class (here
        // "person.class")to appropriate view in Card
        // view (here "person.xml")
        holder.no_of_adult.setText(model.getNo_of_adult());
        holder.no_of_children.setText(model.getNo_of_children());
        holder.phone.setText(model.getPhone());

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
                .inflate(R.layout.person5, parent, false);
        return new person5Adapter.personssViewholder(view);
    }

    // Sub Class to create references of the views in Crad
    // view (here "person.xml")
    class personssViewholder
            extends RecyclerView.ViewHolder {
        TextView budget_level, no_of_adult, phone, no_of_children;
        public personssViewholder(@NonNull View itemView)
        {
            super(itemView);

            budget_level
                    = itemView.findViewById(R.id.budget_level);
            phone=itemView.findViewById(R.id.phone);


            no_of_adult = itemView.findViewById(R.id.no_of_adult);
            no_of_children = itemView.findViewById(R.id.no_of_children);
        }
    }

}
