package com.lucky.apisdk.exception;

/**
 * @author lucky
 * @date 2024/6/5
 * @description 自定义异常类
 */
public class ApiException extends Exception{

    private static final long serialVersionUID = 1384064973479020485L;

    private final int code;

    public ApiException(int code,String message) {
        super(message);
        this.code = code;
    }

    public ApiException(ErrorCode errorCode){
        super(errorCode.getMessage());
        this.code = errorCode.getCode();
    }

    public ApiException(ErrorCode errorCode,String message){
        super(message);
        this.code = errorCode.getCode();
    }

    public int getCode() {
        return code;
    }
}
