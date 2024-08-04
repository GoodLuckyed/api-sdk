package com.lucky.apisdk.model.enums;

/**
 * @author lucky
 * @date 2024/6/25
 * @description 请求方法枚举类
 */
public enum RequestMethodEnum {
    GET("GET", "GET"),
    POST("POST", "POST");

    private String text;
    private String value;

    RequestMethodEnum(String text, String value) {
        this.text = text;
        this.value = value;
    }

    public String getText() {
        return text;
    }

    public String getValue() {
        return value;
    }
}
