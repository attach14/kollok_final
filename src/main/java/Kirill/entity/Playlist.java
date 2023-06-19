package Kirill.entity;

import java.util.ArrayList;

public class Playlist {
    public Playlist(String playlistName){
        name = playlistName;
        songs = new ArrayList<Long>();
    }
    public String name;

    public ArrayList<Long> songs;
}
