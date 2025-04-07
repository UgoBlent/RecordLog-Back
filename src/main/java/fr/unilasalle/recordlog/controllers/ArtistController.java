package fr.unilasalle.recordlog.controllers;

import fr.unilasalle.recordlog.exceptions.NotFoundException;
import fr.unilasalle.recordlog.models.Artist;
import fr.unilasalle.recordlog.services.ArtistService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/artists")
@RequiredArgsConstructor
public class ArtistController {
    private final ArtistService artistService;

    @GetMapping
    public List<Artist> getAll() {
        return artistService.getAllArtists();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Artist> getArtistById(@PathVariable Long id) throws NotFoundException {
        return ResponseEntity.ok(artistService.getArtistById(id));
    }


    @PostMapping
    public ResponseEntity<Artist> add(@RequestBody Artist artist) {
        return ResponseEntity.ok(artistService.addArtist(artist));
    }

    @GetMapping("/search")
    public ResponseEntity<List<Artist>> search(@RequestParam String name) {
        return ResponseEntity.ok(artistService.searchByName(name));
    }
}
