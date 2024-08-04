package com.lucky.apisdk.model.response;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author lucky
 * @date 2024/6/25
 * @description 随机壁纸响应
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class RandomWallpaperResponse extends ResultResponse{
    private static final long serialVersionUID = -2398068490231580697L;
    private String imgUrl;
}
