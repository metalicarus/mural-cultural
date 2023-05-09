package com.hobgobllin.mulralcultural.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hobgobllin.mulralcultural.entity.Artist;
import com.hobgobllin.mulralcultural.repository.ArtistRepository;

@RestController
@RequestMapping("/api")
public class ArtistController {

    @Autowired
    private ArtistRepository artistRepository;

    @GetMapping("/artists")
    public List<Artist> getAllArtists() {
        return artistRepository.findAll();
    }

    @GetMapping("/artists/{id}")
    public ResponseEntity<Artist> getArtistById(@PathVariable(value = "id") Long artistId) {
        Optional<Artist> optionalArtist = artistRepository.findById(artistId);
        if (optionalArtist.isPresent()) {
            return ResponseEntity.ok().body(optionalArtist.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/artists")
    public ResponseEntity<Artist> createArtist(@RequestBody Artist artist) {
        try {
            Artist savedArtist = artistRepository.save(artist);
            return ResponseEntity.created(new URI("/api/artists/" + savedArtist.getId())).body(savedArtist);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/artists/{id}")
    public ResponseEntity<Artist> updateArtist(@PathVariable(value = "id") Long artistId,
                                                @RequestBody Artist artistDetails) {
        Optional<Artist> optionalArtist = artistRepository.findById(artistId);
        if (optionalArtist.isPresent()) {
            Artist artist = optionalArtist.get();
            artist.setName(artistDetails.getName());
            return ResponseEntity.ok(artistRepository.save(artist));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/artists/{id}")
    public ResponseEntity<Artist> deleteArtist(@PathVariable(value = "id") Long artistId) {
        Optional<Artist> optionalArtist = artistRepository.findById(artistId);
        if (optionalArtist.isPresent()) {
            artistRepository.delete(optionalArtist.get());
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
