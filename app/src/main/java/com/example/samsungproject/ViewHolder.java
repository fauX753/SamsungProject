package com.example.samsungproject;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ViewHolder extends RecyclerView.ViewHolder {

    TextView msgItem;
    ImageView imageView;

    public ViewHolder(@NonNull View itemView, Boolean type) {
        super(itemView);
        msgItem = itemView.findViewById(R.id.msgText2);
        imageView = itemView.findViewById(R.id.avatar2);
    }
}
