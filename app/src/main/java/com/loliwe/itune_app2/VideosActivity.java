package com.loliwe.itune_app2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.PlayerConstants;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;

public class VideosActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    static ArrayList<dataModel> playList;
    //VideoCollection videoCollection = new VideoCollection();
    //String videoId = videoCollection.YouTubePlayer(3);
    willBeAdapter willBeAdapter;
    //FloatingActionButton floatingAcBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_videos);

        //floatingAcBtn = (FloatingActionButton) findViewById(R.id.floatingBtn);

        recyclerView =  (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        playList = new ArrayList<>();
        playList.add(new dataModel( "Paphos", "Loliwe", "FYwYdf1it9I"));
        playList.add(new dataModel("Jehova Retshepile Wena","Spirit Of Praise 6", "CL6L56pMYTo"));
        playList.add(new dataModel("IFRS 5", "Thando", "MRbjMaV_5WY"));
        //videoCollection.add(new dataModel("Drugs found at sea", "Many civilians are trapped for weeks underground in the besieged Azovstal steel plant in Mairupol...",R.drawable.oipx4));
        //videoCollection.add(new dataModel("Facebook rapist re-arrested", "Many civilians are trapped for weeks underground in the besieged Azovstal steel plant in Mairupol...",R.drawable.oip6));

        willBeAdapter = new willBeAdapter(this, playList);
        recyclerView.setAdapter(willBeAdapter);

        //recyclerView.setItemAnimator(new DefaultItemAnimator());

        //floatingAcBtn.setOnClickListener(v -> videoCollection.add(new dataModel("type a title", "News story goes here....",R.drawable.oip5)));

    }

    //public Context getContext() {
    //}
}