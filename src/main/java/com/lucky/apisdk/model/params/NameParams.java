package com.lucky.apisdk.model.params;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author lucky
 * @date 2024/4/28
 * @description
 */
@Data
@Accessors(chain = true)
public class NameParams implements Serializable {
    private static final long serialVersionUID = 1408497128462847254L;

    private String name;
}
