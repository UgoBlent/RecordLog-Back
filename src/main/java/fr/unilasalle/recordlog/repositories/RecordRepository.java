package fr.unilasalle.recordlog.repositories;

import fr.unilasalle.recordlog.models.Record;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecordRepository extends JpaRepository<Record, Long> {
    List<Record> findByArtistID(long artistID);
    List<Record> findByTitleContainingIgnoreCase(String title);
    List<Record> findByArtistId(Long artistId);
}
