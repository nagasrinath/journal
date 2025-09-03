/* (C) 2025 Naga Srinath */
package dev.n45.journal.mapper;

import java.util.List;
import java.util.Objects;

import dev.n45.journal.datatype.JournalItem;
import dev.n45.journal.datatype.response.JournalResponse;
import dev.n45.journal.entity.journal.Journal;

public class JournalMapper {

  public JournalItem toJournalItem(Journal journal) {
    if (Objects.isNull(journal)) {
      return null;
    }

    return JournalItem.builder()
        .id(journal.getExternalId())
        .title(journal.getTitle())
        .content(journal.getContent())
        .mood("HAPPY")
        .build();
  }

  public JournalResponse toJournalResponseList(List<Journal> journalList) {
    if (Objects.isNull(journalList)) {
      return null;
    }

    return JournalResponse.builder()
        .total(journalList.size())
        .journals(journalList.stream().map(this::toJournalItem).toList())
        .build();
  }
}
