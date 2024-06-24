package com.lucky.apisdk.model.request;

import com.lucky.apisdk.model.response.ResultResponse;
import lombok.experimental.Accessors;

/**
 * @author lucky
 * @date 2024/5/24
 * @description 通用请求
 */
@Accessors(chain = true)
public class CurrencyRequest extends BaseRequest<Object, ResultResponse>{

    private String method;

    private String path;


    @Override
    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public String getPath() {
        return path;
    }

    @Override
    public Class<ResultResponse> getResponseClass() {
        return ResultResponse.class;
    }
}
