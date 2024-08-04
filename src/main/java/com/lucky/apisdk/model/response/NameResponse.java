package com.lucky.apisdk.model.response;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author lucky
 * @date 2024/4/28
 * @description 名称响应
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class NameResponse extends ResultResponse{
    private static final long serialVersionUID = -1415887139271732895L;

    private String name;
}
