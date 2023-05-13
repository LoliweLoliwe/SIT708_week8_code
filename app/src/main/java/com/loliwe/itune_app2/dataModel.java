package com.loliwe.itune_app2;

import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;

public class dataModel {

    String name;
    String title;
    String youTubePlayerView;
    //String button;

    public dataModel(String title, String name, String youTubePlayerView) {
        this.title = title;
        this.name = name;
        this.youTubePlayerView = youTubePlayerView;
        //this.button = button;
    }

    public String getTitle() {
        return title;
    }

    public String getName() {
        return name;
    }

    public String getVideos() {
        return youTubePlayerView;
    }

    //public String getButton() { return button; }

}
