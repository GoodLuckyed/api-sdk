package com.lucky.apisdk.exception;

import lombok.Data;

/**
 * @author lucky
 * @date 2024/6/11
 * @description
 */
@Data
public class ErrorResponse {
    private String message;
    private int code;
}
