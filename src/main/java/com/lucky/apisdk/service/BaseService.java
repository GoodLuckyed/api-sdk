package com.lucky.apisdk.service;

import cn.hutool.crypto.SecureUtil;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.json.JSONUtil;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.lucky.apisdk.client.ApiClient;
import com.lucky.apisdk.exception.ApiException;
import com.lucky.apisdk.exception.ErrorCode;
import com.lucky.apisdk.exception.ErrorResponse;
import com.lucky.apisdk.model.request.BaseRequest;
import com.lucky.apisdk.model.response.ResultResponse;
import com.lucky.apisdk.utils.SignUtils;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lucky
 * @date 2024/6/5
 * @description
 */
@Slf4j
@Data
public abstract class BaseService implements ApiService{

    private ApiClient apiClient;

    /**
     * 网关HOST
     */
    //TODO 临时值
    private String gatewayHost = "https://gateway.qimuu.icu/api";

    /**
     * 通用请求
     * @param apiClient
     * @param request
     * @return
     * @param <O>
     * @param <T>
     * @throws ApiException
     */
    @Override
    public <O, T extends ResultResponse> T request(ApiClient apiClient, BaseRequest<O, T> request) throws ApiException {
        checkConfig(apiClient);
        return request(request);
    }

    /**
     * 通用请求
     * @param request
     * @return
     * @param <O>
     * @param <T>
     * @throws ApiException
     */
    @Override
    public <O, T extends ResultResponse> T request(BaseRequest<O, T> request) throws ApiException {
        try {
            return res(request);
        } catch (Exception e) {
            throw new ApiException(ErrorCode.OPERATION_ERROR,e.getMessage());
        }
    }

    /**
     * 获取响应数据
     * @param request
     * @return
     * @param <O>
     * @param <T>
     */
    public <O,T extends ResultResponse> T res(BaseRequest<O,T> request) throws ApiException {
        if (apiClient == null || StringUtils.isAnyBlank(apiClient.getAccessKey(),apiClient.getSecretKey())){
            throw new ApiException(ErrorCode.NO_AUTH_ERROR,"请先配置密钥AccessKey/SecretKey");
        }
        T rsp;
        Class<T> clazz = request.getResponseClass();
        try {
            rsp = clazz.newInstance();
        } catch (Exception e) {
            throw new ApiException(ErrorCode.OPERATION_ERROR,e.getMessage());
        }
        // 执行请求，获取响应数据
        HttpResponse httpResponse = doRequest(request);
        String body = httpResponse.body();
        HashMap<String, Object> data = new HashMap<>();
        if (httpResponse.getStatus() != 200){
            ErrorResponse errorResponse = JSONUtil.toBean(body, ErrorResponse.class);
            data.put("errorMessage",errorResponse.getMessage());
            data.put("code",errorResponse.getCode());
        }else {
            try {
                // 尝试解析为JSON对象
                data = new Gson().fromJson(body,new TypeToken<Map<String,Object>>(){}.getType());
            } catch (JsonSyntaxException e) {
                // 解析失败，将body作为普通字符串处理
                data.put("value",body);
            }
        }
        rsp.setData(data);
        return rsp;
    }

    /**
     * 执行请求
     * @param request
     * @return
     * @param <O>
     * @param <T>
     * @throws ApiException
     */
    private <O,T extends ResultResponse> HttpResponse doRequest(BaseRequest<O,T> request) throws ApiException {
        try {
            HttpResponse httpResponse = getHttpRequestByRequestMethod(request).execute();
            return httpResponse;
        } catch (ApiException e) {
            throw new ApiException(ErrorCode.OPERATION_ERROR,e.getMessage());
        }
    }

    /**
     * 通过请求方法获取http响应
     * @param request
     * @return
     * @param <O>
     * @param <T>
     * @throws ApiException
     */
    private <O, T extends ResultResponse> HttpRequest getHttpRequestByRequestMethod(BaseRequest<O,T> request) throws ApiException {
        if (ObjectUtils.isEmpty(request)){
            throw new ApiException(ErrorCode.OPERATION_ERROR,"请求参数错误");
        }
        //获取请求的url路径、方法
        String path = request.getPath().trim();
        String method = request.getMethod().trim().toUpperCase();
        if (ObjectUtils.isEmpty(path)){
            throw new ApiException(ErrorCode.OPERATION_ERROR,"请求路径不存在");
        }
        if (ObjectUtils.isEmpty(method)){
            throw new ApiException(ErrorCode.OPERATION_ERROR,"请求方法不存在");
        }
        if (path.startsWith(gatewayHost)){
            path = path.substring(gatewayHost.length());
        }
        log.info("请求方法：{}，请求路径：{}，请求参数：{}",method,path,request.getRequestParams());
        HttpRequest httpRequest;
        switch (method){
            case "GET":
                httpRequest = HttpRequest.get(splicingGetRequest(request,path));
                break;
            case "POST":
                httpRequest = HttpRequest.post(gatewayHost + path);
                break;
            default:
                throw new ApiException(ErrorCode.OPERATION_ERROR,"不支持该请求");
        }
        return httpRequest.addHeaders(getHeaders(JSONUtil.toJsonStr(request),apiClient)).body(JSONUtil.toJsonStr(request.getRequestParams()));
    }

    /**
     * 获取请求头
     * @param body
     * @param apiClient
     * @return
     */
    private Map<String, String> getHeaders(String body, ApiClient apiClient) {
        HashMap<String, String> map = new HashMap<>();
        map.put("accessKey",apiClient.getAccessKey());
        String encodeBody = SecureUtil.md5(body);
        map.put("body",encodeBody);
        map.put("timeStamp",String.valueOf(System.currentTimeMillis() / 1000));
        map.put("sign", SignUtils.getSign(encodeBody,apiClient.getSecretKey()));
        return map;
    }

    /**
     * 拼接GET请求
     * @param request
     * @param path
     * @return
     * @param <O>
     * @param <T>
     */
    private <O, T extends ResultResponse> String splicingGetRequest(BaseRequest<O,T> request, String path) {
        StringBuilder urlBuilder = new StringBuilder(gatewayHost);
        // urlBuilder最后是/结尾且path以/开头的情况下，去掉urlBuilder结尾的/
        if (urlBuilder.toString().endsWith("/") && path.startsWith("/")){
            urlBuilder.setLength(urlBuilder.length() - 1);
        }
        urlBuilder.append(path);
        if (!request.getRequestParams().isEmpty()){
            urlBuilder.append("?");
            for (Map.Entry<String, Object> entry : request.getRequestParams().entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue().toString();
                urlBuilder.append(key).append("=").append(value).append("&");
            }
            urlBuilder.deleteCharAt(urlBuilder.length() - 1);
        }
        log.info("GET请求路径：{}",urlBuilder);
        return urlBuilder.toString();
    }

    /**
     * 检查配置
     * @param apiClient
     * @throws ApiException
     */
    public void checkConfig(ApiClient apiClient) throws ApiException {
        if (apiClient == null && this.getApiClient() == null){
            throw new ApiException(ErrorCode.NO_AUTH_ERROR,"请先配置密钥AccessKey/SecretKey");
        }
        if (apiClient != null && !StringUtils.isAnyBlank(apiClient.getAccessKey(),apiClient.getSecretKey())){
            this.setApiClient(apiClient);
        }
    }
}
