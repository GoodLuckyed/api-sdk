package com.lucky.apisdk.model.request;

import com.lucky.apisdk.model.enums.RequestMethodEnum;
import com.lucky.apisdk.model.params.RandomWallpaperParams;
import com.lucky.apisdk.model.response.RandomWallpaperResponse;
import lombok.experimental.Accessors;

/**
 * @author lucky
 * @date 2024/6/25
 * @description 随机壁纸请求
 */
@Accessors(chain = true)
public class RandomWallpaperRequest extends BaseRequest<RandomWallpaperParams, RandomWallpaperResponse>{
    @Override
    public String getMethod() {
        return RequestMethodEnum.GET.getValue();
    }

    @Override
    public String getPath() {
        return "/randomWallpaper";
    }

    @Override
    public Class<RandomWallpaperResponse> getResponseClass() {
        return RandomWallpaperResponse.class;
    }
}
