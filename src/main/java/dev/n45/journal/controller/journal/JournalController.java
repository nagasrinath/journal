/* (C) 2025 Naga Srinath */
package dev.n45.journal.controller.journal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import dev.n45.journal.datatype.request.JournalRequest;
import dev.n45.journal.datatype.response.JournalResponse;
import dev.n45.journal.entity.journal.Journal;
import dev.n45.journal.mapper.JournalMapper;
import dev.n45.journal.service.journal.JournalService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class JournalController {

  @Autowired private JournalService journalService;

  @PostMapping("/journals")
  public ResponseEntity<Journal> createJournal(
      @RequestBody JournalRequest journalRequest,
      @RequestHeader(name = "X-User-Id") String userId) {

    var response = journalService.createJournal(journalRequest, userId);

    return new ResponseEntity<>(response, HttpStatus.CREATED);
  }

  @GetMapping("/journals/{id}")
  public Journal getJournalById(
      @PathVariable String id, @RequestHeader(name = "X-User-Id") String userId) {
    return journalService.getJournalById(id, userId);
  }

  @GetMapping("/journals")
  public ResponseEntity<JournalResponse> getAllJournals(
      @RequestHeader(name = "X-User-Id") String userId) {
    JournalResponse response =
        new JournalMapper().toJournalResponseList(journalService.getAllJournals(userId));

    return new ResponseEntity<>(response, HttpStatus.OK);
  }

  @DeleteMapping("/journals/{id}")
  public ResponseEntity<Void> deleteJournalById(@PathVariable String id, @RequestHeader(name = "X-User-Id") String userId) {
      journalService.deleteJournalById(id, userId);
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }
}
