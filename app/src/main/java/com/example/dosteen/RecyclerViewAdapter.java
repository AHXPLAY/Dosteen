package com.example.dosteen;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.RecycleViewHolder> {

    private ArrayList<ItemOfListOfHobbies> arrayList;
    public static class RecycleViewHolder extends RecyclerView.ViewHolder{
        public TextView nameOfHobby;
        public TextView location;

        public RecycleViewHolder(@NonNull View itemView) {
            super(itemView);
            nameOfHobby = itemView.findViewById(R.id.nameOfHobby);
            location = itemView.findViewById(R.id.location);

        }

    }
    @NonNull
    @Override
    public RecycleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view  = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycle_view_item, parent, false);
        RecycleViewHolder recycleViewHolder = new RecycleViewHolder(view);
        return recycleViewHolder;
    }

    public RecyclerViewAdapter (ArrayList<ItemOfListOfHobbies> arrayList){
        this.arrayList = arrayList;
    }
    @Override
    public void onBindViewHolder(@NonNull RecycleViewHolder holder, int position) {
        ItemOfListOfHobbies itemOfListOfHobbies = arrayList.get(position);

        holder.nameOfHobby.setText(itemOfListOfHobbies.getNameOfHobby());
        holder.location.setText(itemOfListOfHobbies.getLocation());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }


}
