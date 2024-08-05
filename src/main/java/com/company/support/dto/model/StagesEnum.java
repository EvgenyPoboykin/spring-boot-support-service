package com.company.support.dto.model;

public enum StagesEnum {
  NEW("NEW", "Новое"),
  DONE("DONE", "Сделано"),
  IN_PROCESS("IN_PROCESS", "В процессе"),
  REJECTED("REJECTED", "Отклонено");

  public final StageJsonDto object;

  private StagesEnum(String value, String label) {
    this.object = new StageJsonDto(value, label);
  }
}
