package com.lucky.apisdk.model.response;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author lucky
 * @date 2024/8/5
 * @description 笑话响应
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class JokeResponse extends ResultResponse{
    private static final long serialVersionUID = -2686727688366287019L;
}
