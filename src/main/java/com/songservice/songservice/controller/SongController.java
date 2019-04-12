package com.songservice.songservice.controller;

import com.songservice.songservice.models.Song;
import com.songservice.songservice.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SongController {

    SongService songService;

    @Autowired
    public SongController(SongService songService){
        this.songService=songService;
    }


    @PostMapping("/song")
    public Song addSong(@RequestBody Song song){
       return  songService.saveSong(song);

    }

//
//    @GetMapping("/songs")
//    public List<Song> listSong() {
//        return songService.retrieveSongs();
//    }


    @GetMapping("/songs/{title}")
    public List<Song> getSongsByTitle(@PathVariable String title){
        return songService.retrieveSongsByTitle(title);
    }


    @GetMapping("/songs/artist/{artist}")
    public List<Song> getSongsByArtist(@PathVariable String artist){
        return songService.getSongByArtist(artist);
    }


}

