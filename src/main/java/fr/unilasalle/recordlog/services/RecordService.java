package fr.unilasalle.recordlog.services;

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
    /*public Record updateRecord(Record record) throws NotFoundException {
        if (record.getId() == null) {
            record = this.recordRepository.save(record);
            return record;
        } else {
            Record finalRecord = record;
            Optional<Record> found = this.getRecords()
                    .stream()
                    .filter(lightKnown -> lightKnown.getId().compareTo(finalRecord.getId()) == 0)
                    .findFirst();
            if (found.isEmpty()) {
                log.error("Light with id {} not found", record.getId());
                throw new NotFoundException("Can't update light", "Can't find Light with id : " + record.getId());
            }

            this.recordRepository.save(found.get());
            return found.get();
        }
    }*/


}
