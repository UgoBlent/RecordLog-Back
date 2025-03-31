package fr.unilasalle.recordlog.services;

import fr.unilasalle.recordlog.exceptions.NotFoundException;
import fr.unilasalle.recordlog.models.Record;
import fr.unilasalle.recordlog.repositories.RecordRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
@Slf4j
public class RecordService {
    private final RecordRepository recordRepository;
    private long lastId = 0;

    public List<Record> getRecords() {
        return this.recordRepository.findAll();
    }

    public Record addRecord(Record record) {
        return recordRepository.save(record);
    }

    public Record updateRecordById(Long id, Record updatedRecord) throws NotFoundException {
        return recordRepository.findById(id).map(existing -> {
            existing.setTitle(updatedRecord.getTitle());
            existing.setArtistID(updatedRecord.getArtistID());
            existing.setFormat(updatedRecord.getFormat());
            existing.setDate(updatedRecord.getDate());
            existing.setGenre(updatedRecord.getGenre());
            existing.setLabel(updatedRecord.getLabel());
            existing.setSongsList(updatedRecord.getSongsList());
            existing.setCoverLink(updatedRecord.getCoverLink());
            existing.setSpotifyLink(updatedRecord.getSpotifyLink());
            return recordRepository.save(existing);
        }).orElseThrow(() -> new NotFoundException("Record not found", "No record with id: " + id));
    }

    public void deleteRecordById(Long id) throws NotFoundException {
        if (!recordRepository.existsById(id)) {
            throw new NotFoundException("Delete failed", "No record with id: " + id);
        }
        recordRepository.deleteById(id);
    }

    public List<Record> searchByTitle(String keyword) {
        System.out.println("🔍 Recherche dans la BDD avec : " + keyword);
        return recordRepository.findByTitleContainingIgnoreCase(keyword);
    }

    public List<Record> findByArtistID(long artistId) {
        return recordRepository.findByArtistID(artistId);
    }

    public List<Record> getRecordsByArtistId(Long artistId) {
        return recordRepository.findByArtistId(artistId);
    }

}
