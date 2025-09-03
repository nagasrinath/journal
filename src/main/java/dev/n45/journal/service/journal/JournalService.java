package dev.n45.journal.service.journal;

import dev.n45.journal.datatype.request.JournalRequest;
import dev.n45.journal.entity.journal.Journal;

public interface JournalService {
    Journal createJournal(JournalRequest journalRequest, String userId);
    Journal getJournalById(String id);
    Iterable<Journal> getAllJournals(String userId);
}
