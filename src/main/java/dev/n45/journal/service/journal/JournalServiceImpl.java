/* (C) 2025 Naga Srinath */
package dev.n45.journal.service.journal;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.n45.journal.datatype.request.JournalRequest;
import dev.n45.journal.entity.journal.Journal;
import dev.n45.journal.mapper.JournalMapper;
import dev.n45.journal.repository.journal.JournalRepository;
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

    journalRepository.save(journal);

    return journal;
  }

  @Override
  public Journal getJournalById(String id, String userId) {
    return journalRepository.findJournalByExternalIdAndUserId(id, userId);
  }

  JournalMapper journalMapper = new JournalMapper();

  @Override
  public List<Journal> getAllJournals(String userId) {
    return journalRepository.getJournalsByUserId(userId);
  }
}
