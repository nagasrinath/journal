/* (C) 2025 My Project */
package dev.n45.journal.repository.journal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.n45.journal.entity.journal.Journal;

@Repository
public interface JournalRepository extends JpaRepository<Journal, Long> {
  Journal findJournalByExternalId(String externalId);

  Iterable<Journal> getJournalsByUserId(String userId);

  Journal findJournalByExternalIdAndUserId(String externalId, String userId);
}
