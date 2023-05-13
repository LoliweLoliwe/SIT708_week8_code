package com.loliwe.itune_app2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.MediaController;
import android.widget.Toast;

import android.view.Window;
import android.view.WindowManager;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.PlayerConstants;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;

public class YoutubeActivity extends AppCompatActivity {

    EditText url;
    String playing ="true";
    Button btn1;
    private Boolean playWhenReady = true;
    private  int currentItem = 0;
    private long playbackPosition = 0L;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_youtube);

        String videoId = "nzTPlrbi5f0";
        EditText url = findViewById(R.id.editTxt5);
        btn1 = findViewById(R.id.button7);

        final YouTubePlayerView youTubePlayerView = findViewById(R.id.videovw);

        // here we are adding observer to our youtubeplayerview.
        getLifecycle().addObserver(youTubePlayerView);

        youTubePlayerView.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
            @Override
            public void onReady(@NonNull YouTubePlayer youTubePlayer) {
                // loading the selected video into the YouTube Player
                youTubePlayer.loadVideo(videoId, 0);
            }

            @Override
            public void onStateChange(@NonNull YouTubePlayer youTubePlayer, @NonNull PlayerConstants.PlayerState state) {// this method is called if video has ended,
                super.onStateChange(youTubePlayer, state);
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(YoutubeActivity.this, HomeActivity.class));
            }
        });
    }

    public void addToList(View view) {
        //String videoID = view.getContentDescription().toString();
        //MediaStore.Video video = videoCollection.searchById(videoID);

        //playList.add(new dataModel("When somebody loves you back", "TP", "nzTPlrbi5f0"));
        //RecyclerView.getAdapter().notifyItemInserted(videoCollection.size());

        Toast.makeText(YoutubeActivity.this, "This button is not connected to the playlist.", Toast.LENGTH_LONG).show();
    }
}