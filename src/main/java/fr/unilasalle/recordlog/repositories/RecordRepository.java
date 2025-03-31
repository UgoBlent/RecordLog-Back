package fr.unilasalle.recordlog.repositories;

import fr.unilasalle.recordlog.models.Record;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecordRepository extends JpaRepository<Record, Long> {
}