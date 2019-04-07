package com.example.cy.enums;

import lombok.Getter;

@Getter
public enum SendCarEnum {
    YES(1,"送车上门"),
    NO(0,"不送车上门");

    private Integer code;

    private String message;

    SendCarEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
