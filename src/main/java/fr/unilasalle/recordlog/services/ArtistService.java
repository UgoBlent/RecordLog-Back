package fr.unilasalle.recordlog.services;

import fr.unilasalle.recordlog.exceptions.NotFoundException;
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

    public Artist getArtistById(Long id) throws NotFoundException {
        return artistRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Artist not found", "No artist with id: " + id));
    }

    public List<Artist> searchByName(String name) {
        return artistRepository.findByNameContainingIgnoreCase(name);
    }

    public Artist addArtist(Artist artist) {
        return artistRepository.save(artist);
    }
}
