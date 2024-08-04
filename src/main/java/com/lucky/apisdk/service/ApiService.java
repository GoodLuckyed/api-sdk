package com.lucky.apisdk.service;

import com.lucky.apisdk.client.ApiClient;
import com.lucky.apisdk.exception.ApiException;
import com.lucky.apisdk.model.request.*;
import com.lucky.apisdk.model.response.*;

/**
 * @author lucky
 * @date 2024/6/5
 * @description
 */
public interface ApiService {

    /**
     * 通用请求
     * @param apiClient
     * @param request
     * @return
     * @param <O>
     * @param <T>
     * @throws ApiException
     */
    <O, T extends ResultResponse> T request(ApiClient apiClient, BaseRequest<O, T> request) throws ApiException;

    /**
     * 通用请求
     * @param request
     * @return
     * @param <O>
     * @param <T>
     * @throws ApiException
     */
    <O,T extends ResultResponse> T request(BaseRequest<O,T> request) throws ApiException;

    /**
     * 随机获取毒鸡汤
     * @return
     * @throws ApiException
     */
    PoisonousChickenSoupResponse getPoisonousChickenSoup(PoisonousChickenSoupRequest request) throws ApiException;

    /**
     * 随机获取毒鸡汤
     * @param apiClient
     * @return
     * @throws ApiException
     */
    PoisonousChickenSoupResponse getPoisonousChickenSoup(PoisonousChickenSoupRequest request, ApiClient apiClient) throws ApiException;

    /**
     * 获取随机壁纸
     * @param request
     * @return
     * @throws ApiException
     */
    RandomWallpaperResponse getRandomWallpaper(RandomWallpaperRequest request) throws ApiException;

    /**
     * 获取随机壁纸
     * @param apiClient
     * @param request
     * @return
     * @throws ApiException
     */
    RandomWallpaperResponse getRandomWallpaper(RandomWallpaperRequest request, ApiClient apiClient) throws ApiException;

    /**
     * 获取随机土味情话
     * @param request
     * @return
     * @throws ApiException
     */
    LoveResponse getRandomLoveTalk(LoveRequest request) throws ApiException;

    /**
     * 获取随机土味情话
     * @param request
     * @param apiClient
     * @return
     * @throws ApiException
     */
    LoveResponse getRandomLoveTalk(LoveRequest request, ApiClient apiClient) throws ApiException;

    /**
     * 获取随机笑话
     * @param request
     * @return
     * @throws ApiException
     */
    JokeResponse getRandomJoke(JokeRequest request) throws ApiException;

    /**
     * 获取随机笑话
     * @param request
     * @param apiClient
     * @return
     * @throws ApiException
     */
    JokeResponse getRandomJoke(JokeRequest request, ApiClient apiClient) throws ApiException;
}
