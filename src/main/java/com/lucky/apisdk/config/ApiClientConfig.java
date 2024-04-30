package com.lucky.apisdk.config;

import com.lucky.apisdk.client.ApiClient;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author lucky
 * @date 2024/4/28
 * @description API客户端配置
 */
@Configuration
@ConfigurationProperties("api.client")
@Data
@ComponentScan
public class ApiClientConfig {

    /**
     * 访问密钥
     */
    private String accessKey;

    /**
     * 私密密钥
     */
    private String secretKey;

    /**
     * 网关
     */
    private String host;

    @Bean
    public ApiClient apiClient(){
        return new ApiClient(accessKey, secretKey);
    }
}
