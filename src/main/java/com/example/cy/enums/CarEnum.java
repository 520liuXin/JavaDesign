package com.example.cy.enums;

import lombok.Getter;

@Getter
public enum CarEnum {
    NEW_HEAT_VALUE(100L,"初始值");


    private Long code;

    private String message;

    CarEnum(Long code, String message) {
        this.code = code;
        this.message = message;
    }
}
