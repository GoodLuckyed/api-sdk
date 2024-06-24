package com.lucky.apisdk.service;

import com.lucky.apisdk.client.ApiClient;
import com.lucky.apisdk.exception.ApiException;
import com.lucky.apisdk.model.request.BaseRequest;
import com.lucky.apisdk.model.response.ResultResponse;

/**
 * @author lucky
 * @date 2024/6/5
 * @description
 */
public interface ApiService {

    /**
     * 通用请求
     * @param apiClient
     * @param request
     * @return
     * @param <O>
     * @param <T>
     * @throws ApiException
     */
    <O, T extends ResultResponse> T request(ApiClient apiClient, BaseRequest<O, T> request) throws ApiException;

    /**
     * 通用请求
     * @param request
     * @return
     * @param <O>
     * @param <T>
     * @throws ApiException
     */
    <O,T extends ResultResponse> T request(BaseRequest<O,T> request) throws ApiException;
}
