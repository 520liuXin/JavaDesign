package com.example.cy.enums;

import lombok.Getter;

@Getter
public enum CarEnum {
    STSTE_NO_RENT_OUT(0,"未出租"),
    STATE_RENT_OUT(1,"出租"),
    STATE_SOLD_OUT(2,"下架");


    private Integer code;

    private String message;

    CarEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
