package com.songservice.songservice.controller;

import com.songservice.songservice.models.Song;
import com.songservice.songservice.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class SongController {

    @Autowired
    Environment env;

    SongService songService;


    @Autowired
    public SongController(SongService songService){
        this.songService=songService;
    }


    @PostMapping("/song")
    public Song addSong(@RequestBody Song song){
       return  songService.saveSong(song);

    }


    @GetMapping("/song/{id}")
    public Optional<Song> getSong(@PathVariable String id) {
        System.out.println("Local host Values....."+env.getProperty("local.server.port"));

        return songService.getSongById(id);
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

