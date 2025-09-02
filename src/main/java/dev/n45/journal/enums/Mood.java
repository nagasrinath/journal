package dev.n45.journal.enums;

import lombok.Getter;

@Getter
public enum Mood {
  HAPPY("HAPPY"),
  SAD("SAD"),
  NEUTRAL("NEUTRAL"),
  EXCITED("EXCITED"),
  ANXIOUS("ANXIOUS");

  private final String value;

  Mood(String value) {
    this.value = value;
  }
}
