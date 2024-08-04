package com.lucky.apisdk.model.request;

import com.lucky.apisdk.model.enums.RequestMethodEnum;
import com.lucky.apisdk.model.params.PoisonousChickenSoupParams;
import com.lucky.apisdk.model.response.PoisonousChickenSoupResponse;
import lombok.experimental.Accessors;

/**
 * @author lucky
 * @date 2024/6/25
 * @description 毒鸡汤请求
 */
@Accessors(chain = true)
public class PoisonousChickenSoupRequest extends BaseRequest<PoisonousChickenSoupParams, PoisonousChickenSoupResponse>{
    @Override
    public String getMethod() {
        return RequestMethodEnum.GET.getValue();
    }

    @Override
    public String getPath() {
        return "/poisonousChickenSoup";
    }

    @Override
    public Class<PoisonousChickenSoupResponse> getResponseClass() {
        return PoisonousChickenSoupResponse.class;
    }
}
