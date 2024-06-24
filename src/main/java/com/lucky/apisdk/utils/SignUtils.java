package com.lucky.apisdk.utils;

import cn.hutool.crypto.digest.MD5;
import cn.hutool.json.JSONUtil;

/**
 * @author lucky
 * @date 2024/6/11
 * @description 签名工具类
 */
public class SignUtils {

    public static String getSign(String body,String secretKey){
        return MD5.create().digestHex(JSONUtil.toJsonStr(body) + "." + secretKey);
    }
}
