package com.loliwe.itune_app2;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;

public class RecyclerViewHolder extends RecyclerView.ViewHolder {

    public TextView txtView1;
    public TextView txtView2;
    final YouTubePlayerView youTubePlayerView;
    //public Button removeBtn;

    public RecyclerViewHolder(@NonNull View itemView) {
        super(itemView);
        txtView1 = itemView.findViewById(R.id.titleTxt);
        txtView2 = itemView.findViewById(R.id.titlePerson);
        youTubePlayerView = itemView.findViewById(R.id.webvw);
        //removeBtn =itemView.findViewById(R.id.removeBtn);
    }
}
