package dev.n45.journal.entity.journal;

import dev.n45.journal.entity.BaseEntity;
import dev.n45.journal.enums.Mood;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Where;

import java.util.UUID;

@ToString
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@SuperBuilder(toBuilder = true)
@DynamicUpdate
@NoArgsConstructor
@Table(
    name = "`journal`",
    uniqueConstraints = {
      @UniqueConstraint(
          name = "external_id_uq_idx",
          columnNames = {"`external_id`"})
    })
@Where(clause = "`active`=1")
public class Journal extends BaseEntity {

  @Column(name = "`external_id`", columnDefinition = "varchar(50)", nullable = false)
  private String externalId;

  @Column(name = "`title`", columnDefinition = "varchar(255)", nullable = false)
  private String title;

  @Column(name = "`content`", columnDefinition = "text", nullable = false)
  private String content;

  @Column(name = "`mood`", columnDefinition = "varchar(50)")
  private Mood mood;

  @Column(name = "`user_id`", columnDefinition = "varchar(50)", nullable = false)
  private String userId;

  @Override
  public void onCreate() {
    super.onCreate();
    this.setExternalId(UUID.randomUUID().toString());
  }
}
