package com.lucky.apisdk.exception;

/**
 * @author lucky
 * @date 2024/6/5
 * @description 错误码
 */
public enum ErrorCode {
    SUCCESS(0,"成功"),
    PARAMS_ERROR(40000,"请求参数错误"),
    PROHIBITED(40001,"账号已封禁"),
    NOT_LOGIN_ERROR(40100,"未登录"),
    NO_AUTH_ERROR(40101,"无权限"),
    NOT_FOUND_ERROR(40400,"请求数据不存在"),
    SYSTEM_ERROR(50000,"系统内部异常"),
    OPERATION_ERROR(50001,"操作失败");

    private final int code;

    private final String message;

    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
