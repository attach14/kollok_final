package Kirill.Controller;

import Kirill.entity.Playlist;
import Kirill.entity.Song;
import Kirill.entity.SongInfo;
import Kirill.entity.SongRequest;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class MusicController {
    private final Map<Long, Song> songDataBase = new HashMap<>();

    private final Map<Long, SongInfo> infoDataBase = new HashMap<>();

    private final Map<Long, Playlist> playlistDataBase = new HashMap<>();
    // Получение списка всех песен
    @GetMapping("/songs")
    public List<Song> getAllSongs() {
        return new ArrayList<>(songDataBase.values());
    }

    // Получение информации о конкретной песне
    @GetMapping("/songs/{id}")
    public SongRequest getSongById(@PathVariable("id") Long id) {
        Song song = songDataBase.get(id);
        SongInfo inf = infoDataBase.get(id);
        return new SongRequest(song, inf);
    }

    // Создание нового плейлиста
    @PostMapping("/playlists")
    public Long createPlaylist(@RequestBody String playlistName) {
        Playlist res = new Playlist(playlistName);
        playlistDataBase.put((long) playlistDataBase.size(), res);
        return (long) (playlistDataBase.size() - 1);
    }

    // Добавление песни в плейлист
    @PostMapping("/playlists/{id}/songs")
    public void addSongToPlaylist(@PathVariable("id") Long id, @RequestBody Long songID) {
        Playlist playlist = playlistDataBase.get(id);
        playlist.songs.add(songID);
    }

    // Оценка песни
    @PostMapping("/ratings")
    public void rateSong(@RequestBody Long SongID, Integer rating) {
        SongInfo res = infoDataBase.get(SongID);
        res.rating = rating;
    }
}