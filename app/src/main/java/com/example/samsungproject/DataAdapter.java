package com.example.samsungproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class DataAdapter extends RecyclerView.Adapter<ViewHolder> {

    LayoutInflater inflater;
    ArrayList<Message> messages;
    ViewHolder holder;

    public DataAdapter(Context context, ArrayList<Message> messages){
        this.messages = messages;
        this.inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.linear_layout_item2, parent, false);
        this.holder = new ViewHolder(view, Boolean.TRUE);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holderi, int position) {
        Message msg = messages.get(position);
        holderi.msgItem.setText(msg.message);

        if(msg.type){
            holderi.imageView.setImageResource(R.drawable.iconbot);
        }else{
            holderi.imageView.setImageResource(R.drawable.iconman);
        }

    }

    @Override
    public int getItemCount() {
        return messages.size();
    }
}