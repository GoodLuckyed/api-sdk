package com.lucky.apisdk.model.request;

import com.lucky.apisdk.model.enums.RequestMethodEnum;
import com.lucky.apisdk.model.response.LoveResponse;
import lombok.experimental.Accessors;

/**
 * @author lucky
 * @date 2024/6/25
 * @description 土味情话请求
 */
@Accessors(chain = true)
public class LoveRequest extends BaseRequest<String, LoveResponse>{
    @Override
    public String getMethod() {
        return RequestMethodEnum.GET.getValue();
    }

    @Override
    public String getPath() {
        return "/loveTalk";
    }

    @Override
    public Class<LoveResponse> getResponseClass() {
        return LoveResponse.class;
    }
}
