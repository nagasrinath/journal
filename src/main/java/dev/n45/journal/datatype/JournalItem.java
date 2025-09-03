/* (C) 2025 Naga Srinath */
package dev.n45.journal.datatype;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import dev.n45.journal.enums.Mood;
import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder(toBuilder = true)
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class JournalItem {
  private String id;
  private String title;
  private String content;
  private Mood mood;
}
