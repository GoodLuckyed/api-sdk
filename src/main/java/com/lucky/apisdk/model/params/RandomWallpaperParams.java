package com.lucky.apisdk.model.params;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author lucky
 * @date 2024/6/25
 * @description 随机壁纸参数
 */
@Data
@Accessors(chain = true)
public class RandomWallpaperParams implements Serializable {
    private static final long serialVersionUID = 4472706935291771258L;
    private String method;
    private String lx;
}
