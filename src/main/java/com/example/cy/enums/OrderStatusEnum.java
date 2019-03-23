package com.example.cy.enums;


import lombok.Getter;

@Getter
public enum OrderStatusEnum {
    NEW(0, "新订单"),
    ORDERING(1, "进行中"),
    FINISH(2, "完结"),
    CANCEL(3, "已取消"),;

    private Integer code;

    private String message;

    OrderStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
