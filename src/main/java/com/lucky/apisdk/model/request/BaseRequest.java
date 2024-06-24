package com.lucky.apisdk.model.request;

import cn.hutool.json.JSONUtil;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.lucky.apisdk.model.response.ResultResponse;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lucky
 * @date 2024/5/24
 * @description 基本api请求
 */
public abstract class BaseRequest<O, T extends ResultResponse>{

    private Map<String,Object> requestParams = new HashMap<>();

    /**
     * 获取请求方法
     * @return
     */
    public abstract String getMethod();

    /**
     * 获取路径
     * @return
     */
    public abstract String getPath();

    /**
     * 获取响应类
     * @return
     */
    public abstract Class<T> getResponseClass();

    @JsonAnyGetter
    public Map<String, Object> getRequestParams() {
        return requestParams;
    }

    public void setRequestParams(O params){
        this.requestParams = new Gson().fromJson(JSONUtil.toJsonStr(params), new TypeToken<Map<String, Object>>(){}.getType());
    }
}
