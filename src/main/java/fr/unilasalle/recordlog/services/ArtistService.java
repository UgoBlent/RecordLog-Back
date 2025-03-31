package fr.unilasalle.recordlog.services;

import fr.unilasalle.recordlog.models.Artist;
import fr.unilasalle.recordlog.repositories.ArtistRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ArtistService {
    private final ArtistRepository artistRepository;

    public List<Artist> getAllArtists() {
        return artistRepository.findAll();
    }

    public List<Artist> searchByName(String name) {
        return artistRepository.findByNameContainingIgnoreCase(name);
    }

    public Artist addArtist(Artist artist) {
        return artistRepository.save(artist);
    }
}
