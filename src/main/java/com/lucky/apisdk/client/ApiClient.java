package com.lucky.apisdk.client;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author lucky
 * @date 2024/4/28
 * @description API客户端
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiClient {

    /**
     * 访问密钥
     */
    private String accessKey;

    /**
     * 私密密钥
     */
    private String secretKey;
}
