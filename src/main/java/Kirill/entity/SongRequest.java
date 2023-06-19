package Kirill.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SongRequest {

    public SongRequest(Song song, SongInfo info) {
        name = song.name;
        artist = song.artist;
        genre = song.genre;
        album = info.album;
        length = info.length;
        rating = info.rating;
    }
    public String name;
    public String artist;
    public String genre;
    public int rating;
    public String album;
    public int length; // в секундах
}
