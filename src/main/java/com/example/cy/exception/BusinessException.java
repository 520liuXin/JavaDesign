package com.example.cy.exception;


import com.example.cy.utils.ResponseInfo;

/**
 * @author Dreamhai
 * @Date 2017/11/6 10:19
 */
public class BusinessException extends Exception  {
    private static final long serialVersionUID = -778142600038732285L;
    private String message;
    private String code;

    public BusinessException(String message) {
        this.message = message;
        this.code = ResponseInfo.CODE_ERROR;
    }

    public BusinessException(String code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public String getCode() {
        return code;
    }

    public ResponseInfo<Object> getResponse() {
        return new ResponseInfo<Object>(code, message, null);
    }
}
