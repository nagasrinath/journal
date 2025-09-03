/* (C) 2025 My Project */
package dev.n45.journal.entity;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Objects;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder(toBuilder = true)
@MappedSuperclass
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"id"})
public abstract class BaseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "`id`", columnDefinition = "bigint(20)")
  protected Long id;

  @Column(
      name = "`created_at`",
      columnDefinition = "DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP",
      updatable = false)
  @CreatedDate
  protected LocalDateTime createdAt;

  @LastModifiedDate
  @Column(name = "`updated_at`", columnDefinition = "DATETIME NULL DEFAULT NULL")
  protected LocalDateTime updatedAt;

  @Version
  @Column(name = "`version`", nullable = false, columnDefinition = "smallint(6)")
  protected int version;

  @Column(name = "`active`", nullable = false, columnDefinition = "tinyint(6)")
  protected Integer active;

  @PrePersist
  public void onCreate() {
    LocalDateTime timestamp = LocalDateTime.now(ZoneId.systemDefault());
    this.createdAt = Objects.isNull(createdAt) ? timestamp : createdAt;
    this.updatedAt = Objects.isNull(updatedAt) ? timestamp : updatedAt;
    this.active = 1;
    this.version = 0;
  }

  @PreUpdate
  public void onUpdate() {
    this.updatedAt = LocalDateTime.now(ZoneId.systemDefault());
  }
}
