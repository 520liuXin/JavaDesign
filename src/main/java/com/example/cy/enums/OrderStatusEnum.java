package com.example.cy.enums;


import lombok.Getter;

@Getter
public enum OrderStatusEnum {
    NEW(0, "待支付"),
    ORDERING(1, "已支付"),

    FINISH(2, "已还车"),
    CANCEL(3, "已取消"),;

    private Integer code;

    private String message;

    OrderStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
