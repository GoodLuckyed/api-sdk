package com.lucky.apisdk.model.request;

import com.lucky.apisdk.model.enums.RequestMethodEnum;
import com.lucky.apisdk.model.response.JokeResponse;
import lombok.experimental.Accessors;

/**
 * @author lucky
 * @date 2024/8/5
 * @description
 */
@Accessors(chain = true)
public class JokeRequest extends BaseRequest<String, JokeResponse>{
    @Override
    public String getMethod() {
        return RequestMethodEnum.GET.getValue();
    }

    @Override
    public String getPath() {
        return "/joke";
    }

    @Override
    public Class<JokeResponse> getResponseClass() {
        return JokeResponse.class;
    }
}
