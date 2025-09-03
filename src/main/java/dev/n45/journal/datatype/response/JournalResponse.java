/* (C) 2025 Naga Srinath */
package dev.n45.journal.datatype.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import dev.n45.journal.datatype.JournalItem;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder(toBuilder = true)
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class JournalResponse {
  @JsonInclude(JsonInclude.Include.NON_NULL)
  private List<JournalItem> journals;

  private Integer total;
}
