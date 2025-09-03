package dev.n45.journal.repository.journal;

import dev.n45.journal.entity.journal.Journal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JournalRepository extends JpaRepository<Journal, Long> {
    Journal findJournalByExternalId(String externalId);

    Iterable<Journal> getJournalsByUserId(String userId);
}
