package fr.unilasalle.recordlog.controllers;

import fr.unilasalle.recordlog.models.Record;
import fr.unilasalle.recordlog.services.RecordService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/record")
@RequiredArgsConstructor
public class RecordController {
    private final RecordService recordService;

    @GetMapping
    public List<Record> getAllRecords() {
        return this.recordService.getRecords();
    }

    @PostMapping
    public ResponseEntity<Record> addLight(@RequestBody Record record) {
        return new ResponseEntity<>(this.recordService.addRecord(record), HttpStatus.OK);
    }
}
