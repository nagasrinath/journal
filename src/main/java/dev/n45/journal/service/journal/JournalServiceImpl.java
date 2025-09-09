/* (C) 2025 Naga Srinath */
package dev.n45.journal.service.journal;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.n45.journal.datatype.request.JournalRequest;
import dev.n45.journal.entity.journal.Journal;
import dev.n45.journal.repository.journal.JournalRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class JournalServiceImpl implements JournalService {

  @Autowired private JournalRepository journalRepository;

  @Override
  public Journal createJournal(JournalRequest journalRequest, String userId) {

    var journal =
        Journal.builder()
            .title(journalRequest.getTitle())
            .content(journalRequest.getContent())
            .mood(journalRequest.getMood())
            .userId(userId)
            .build();

    log.info("Journal created: {}", journal);

    try {
      journalRepository.save(journal);
    } catch (Exception e) {
      log.error("Error while saving journal: {}", e.getMessage());
    }

    return journal;
  }

  @Override
  public List<Journal> getJournalById(String id, String userId) {
    return journalRepository.findJournalsByExternalIdAndUserId(id, userId);
  }

  @Override
  public List<Journal> getAllJournals(String userId) {
    return journalRepository.getJournalsByUserId(userId);
  }

  @Override
  @Transactional
  public void deleteJournalById(String id, String userId) {
    journalRepository.deleteJournal(id, userId);
  }
}
