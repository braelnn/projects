package com.example.Try;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class VPAdapter extends RecyclerView.Adapter<VPAdapter.ViewHolder> {

    ArrayList<viewpageritem> viewpageritemsArrayList;

    public VPAdapter(ArrayList<viewpageritem> viewpageritemsArrayList) {
        this.viewpageritemsArrayList = viewpageritemsArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.viewpager_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        viewpageritem viewpageritem= viewpageritemsArrayList.get(position);
        holder.imageView.setImageResource(viewpageritem.imageID);
        holder.tvheading.setText(viewpageritem.heading);
        holder.tvDesc.setText(viewpageritem.Description);

    }

    @Override
    public int getItemCount() {
        return viewpageritemsArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView tvheading, tvDesc;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView= itemView.findViewById(R.id.ivimage);
            tvheading= itemView.findViewById(R.id.tvheading);
            tvDesc= itemView.findViewById(R.id.tvDesc);

        }
    }

}
