/* (C) 2025 Naga Srinath */
package dev.n45.journal.repository.journal;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import dev.n45.journal.entity.journal.Journal;

@Repository
public interface JournalRepository extends JpaRepository<Journal, Long> {
  List<Journal> getJournalsByUserId(String userId);

  @Modifying
  @Query(
      value = "UPDATE `journal` SET `active` = 0 WHERE external_id=:id AND user_id=:user_id",
      nativeQuery = true)
  void deleteJournal(@Param("id") String id, @Param("user_id") String userId);

  List<Journal> findJournalsByExternalIdAndUserId(String externalId, String externalId1);
}
