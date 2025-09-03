package dev.n45.journal.controller.journal;

import dev.n45.journal.datatype.request.JournalRequest;
import dev.n45.journal.entity.journal.Journal;
import dev.n45.journal.service.journal.JournalService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
public class JournalController {

  @Autowired private JournalService journalService;

  @PostMapping("/journals")
  public ResponseEntity<Journal> createJournal(@RequestBody JournalRequest journalRequest, @RequestHeader(name = "X-User-Id") String userId) {

       var response = journalService.createJournal(journalRequest, userId);

    return new ResponseEntity<>(response, HttpStatus.CREATED);
  }

  @GetMapping("/journals/{id}")
  public Journal getJournalById(@PathVariable String id, @RequestHeader(name = "X-User-Id") String userId) {
    return journalService.getJournalById(id, userId);
  }

  @GetMapping("/journals")
  public Iterable<Journal> getAllJournals(@RequestHeader(name = "X-User-Id") String userId) {
      return journalService.getAllJournals(userId);
  }
}
