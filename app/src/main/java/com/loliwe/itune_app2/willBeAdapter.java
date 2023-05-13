package com.loliwe.itune_app2;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.PlayerConstants;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;

import java.util.ArrayList;

public class willBeAdapter extends RecyclerView.Adapter<RecyclerViewHolder> {

    VideosActivity mContext;
    ArrayList<dataModel> videoCollection;

    public willBeAdapter(VideosActivity mContext, ArrayList<dataModel> videoCollection) {
        this.mContext = mContext;
        this.videoCollection = videoCollection;
    }

    @Override
    public int getItemViewType(final int position) {
        return R.layout.activity_videos;
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //inflating the layout
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_layout, parent, false);
        return new RecyclerViewHolder(view);
        //return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, @SuppressLint("RecyclerView") int position) {
        //attach data to layout views
        holder.txtView1.setText(videoCollection.get(position).getTitle());
        holder.txtView2.setText(videoCollection.get(position).getName());
        //YouTubePlayer youTubePlayer = youTubePlayerView.get(position);
        holder.youTubePlayerView.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
            //holder.youTubePlayerView
           
        /*//holder.youTubePlayerView.s
                //(newsStories.get(position).getImages());
        //holder.removeBtn.setText(videoCollection.get(position).getName());
        YouTubePlayerView youTubePlayerView = youTubePlayerView.findViewById(R.id.webvw);

        getLifecycle().addObserver(this, );
        youTubePlayerView.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {*/
            @Override
            public void onReady(@NonNull YouTubePlayer youTubePlayer) {
                // loading the selected video into the YouTube Player
                youTubePlayer.loadVideo(videoCollection.get(position).getVideos(), 0);
            }

            @Override
            public void onStateChange(@NonNull YouTubePlayer youTubePlayer, @NonNull PlayerConstants.PlayerState state) {
                // this method is called if video has ended,
                super.onStateChange(youTubePlayer, state);
            }
        });
    }


    @Override
    public int getItemCount() {
        //get the size of the array
        return videoCollection.size();
    }
}
