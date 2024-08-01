package com.company.support.model;

public enum StagesEnum {
    NEW("Новое"),
    DONE("Сделано"),
    IN_PROCESS("В процессе"),
    REJECTED("Отклонено");

    public final String label;

    private StagesEnum(String label) {
        this.label = label;
    }
}