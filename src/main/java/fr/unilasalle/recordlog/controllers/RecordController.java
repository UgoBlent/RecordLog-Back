package fr.unilasalle.recordlog.controllers;

import fr.unilasalle.recordlog.exceptions.NotFoundException;
import fr.unilasalle.recordlog.models.Record;
import fr.unilasalle.recordlog.services.RecordService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/records")
@RequiredArgsConstructor
public class RecordController {
    private final RecordService recordService;

    @GetMapping
    public List<Record> getAllRecords() {
        return this.recordService.getRecords();
    }

    @PostMapping
    public ResponseEntity<Record> addRecord(@RequestBody Record record) {
        return new ResponseEntity<>(this.recordService.addRecord(record), HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Record> updateRecord(@PathVariable Long id, @RequestBody Record record) throws NotFoundException {
        Record updated = recordService.updateRecordById(id, record);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRecord(@PathVariable Long id) throws NotFoundException {
        recordService.deleteRecordById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/search")
    public ResponseEntity<List<Record>> searchByTitle(@RequestParam String q) {
        return ResponseEntity.ok(recordService.searchByTitle(q));
    }

    @GetMapping("/by-artist/{artistId}")
    public ResponseEntity<List<Record>> getByArtistId(@PathVariable Long artistId) {
        return ResponseEntity.ok(recordService.getRecordsByArtistId(artistId));
    }

}
