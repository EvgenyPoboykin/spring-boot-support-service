package com.company.support.model;

public enum Stages {
    NEW {
        public String toString() {
            return "Новое";
        }
    }
    , DONE, IN_PROCESS, REJECTED
}