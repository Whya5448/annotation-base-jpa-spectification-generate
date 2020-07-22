package org.metalscraps.demo.jpa.spectification.annotationbasejpaspectificationgenerate.enums;

import lombok.Getter;

public enum GeneralState {
    ENABLED("활성"),
    SAVED("저장"),
    DELETED("삭제"),
    ;

    @Getter
    private final String state;

    GeneralState(String state) {
        this.state = state;
    }
}
