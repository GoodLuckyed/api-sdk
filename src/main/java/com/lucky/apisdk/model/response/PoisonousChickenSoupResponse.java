package com.lucky.apisdk.model.response;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author lucky
 * @date 2024/6/25
 * @description 毒鸡汤响应
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class PoisonousChickenSoupResponse extends ResultResponse{
    private static final long serialVersionUID = -6971389938633768004L;
    private String text;
}
