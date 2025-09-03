package dev.n45.journal.controller.journal;

import dev.n45.journal.datatype.request.JournalRequest;
import dev.n45.journal.entity.journal.Journal;
import dev.n45.journal.service.journal.JournalService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
public class JournalController {

  @Autowired private JournalService journalService;

  @PostMapping("/journals")
  public Journal createJournal(@RequestBody JournalRequest journalRequest, @RequestHeader(name = "X-User-Id") String userId) {
    return journalService.createJournal(journalRequest, userId);
  }

  @GetMapping("/journals/{id}")
  public Journal getJournalById(@PathVariable String id, @RequestHeader(name = "X-User-Id") String userId) {
    return journalService.getJournalById(id);
  }

  @GetMapping("/journals")
  public Iterable<Journal> getAllJournals(@RequestHeader(name = "X-User-Id") String userId) {
      return journalService.getAllJournals(userId);
  }
}
