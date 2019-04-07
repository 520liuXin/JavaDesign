package com.example.cy.utils;

import com.example.cy.enums.CarEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;

import com.google.common.collect.ImmutableMap;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * @Author able-liu
 * @Description
 * @Date  19-3-13
 **/
@Data
@AllArgsConstructor
public class ResponseInfo<T> implements Serializable {
    private static final long serialVersionUID = 0x20170713;
    public static final String KEY_CODE = "code";
    public static final String KEY_MESSAGE = "message";
    public static final String KEY_DATA = "data";
    public static final String CODE_SUCCESS = "0000";
    public static final String CODE_ERROR = "9999";
    private static final ImmutableMap<String, String> codeMap = ImmutableMap.of(
            CODE_SUCCESS, "成功",
            CODE_ERROR, "系统异常，请稍后再试"
    );
    private String code;
    private String message;
    private T data;

    public static <T> ResponseInfo<T> success(T data) {
        return new ResponseInfo<>(CODE_SUCCESS, codeMap.get(CODE_SUCCESS), data);
    }

    public static <T> ResponseInfo<T> error(T data) {
        return new ResponseInfo<>(CODE_ERROR, codeMap.get(CODE_ERROR), data);
    }


    @JsonIgnore
    public boolean isSuccess() {
        return CODE_SUCCESS.equals(code);
    }
}