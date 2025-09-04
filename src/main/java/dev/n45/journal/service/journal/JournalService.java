/* (C) 2025 Naga Srinath */
package dev.n45.journal.service.journal;

import java.util.List;

import dev.n45.journal.datatype.request.JournalRequest;
import dev.n45.journal.entity.journal.Journal;

public interface JournalService {
  Journal createJournal(JournalRequest journalRequest, String userId);

  List<Journal> getJournalById(String id, String userId);

  List<Journal> getAllJournals(String userId);

  void deleteJournalById(String id, String userId);
}
