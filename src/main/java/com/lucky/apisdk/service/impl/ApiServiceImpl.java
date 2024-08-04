package com.lucky.apisdk.service.impl;

import com.lucky.apisdk.client.ApiClient;
import com.lucky.apisdk.exception.ApiException;
import com.lucky.apisdk.model.request.JokeRequest;
import com.lucky.apisdk.model.request.LoveRequest;
import com.lucky.apisdk.model.request.PoisonousChickenSoupRequest;
import com.lucky.apisdk.model.request.RandomWallpaperRequest;
import com.lucky.apisdk.model.response.JokeResponse;
import com.lucky.apisdk.model.response.LoveResponse;
import com.lucky.apisdk.model.response.PoisonousChickenSoupResponse;
import com.lucky.apisdk.model.response.RandomWallpaperResponse;
import com.lucky.apisdk.service.ApiService;
import com.lucky.apisdk.service.BaseService;

/**
 * @author lucky
 * @date 2024/6/12
 * @description
 */
public class ApiServiceImpl extends BaseService implements ApiService {

    /**
     * 随机获取毒鸡汤
     * @return
     * @throws ApiException
     */
    @Override
    public PoisonousChickenSoupResponse getPoisonousChickenSoup(PoisonousChickenSoupRequest request) throws ApiException {
        return request(request);
    }

    /**
     * 随机获取毒鸡汤
     * @param apiClient
     * @return
     * @throws ApiException
     */
    @Override
    public PoisonousChickenSoupResponse getPoisonousChickenSoup(PoisonousChickenSoupRequest request, ApiClient apiClient) throws ApiException {
        return request(apiClient,request);
    }

    /**
     * 获取随机壁纸
     * @param request
     * @return
     * @throws ApiException
     */
    @Override
    public RandomWallpaperResponse getRandomWallpaper(RandomWallpaperRequest request) throws ApiException {
        return request(request);
    }

    /**
     * 获取随机壁纸
     * @param request
     * @param apiClient
     * @return
     * @throws ApiException
     */
    @Override
    public RandomWallpaperResponse getRandomWallpaper(RandomWallpaperRequest request, ApiClient apiClient) throws ApiException {
        return request(apiClient,request);
    }

    /**
     * 随机土味情话
     * @param request
     * @return
     * @throws ApiException
     */
    @Override
    public LoveResponse getRandomLoveTalk(LoveRequest request) throws ApiException {
        return request(request);
    }

    /**
     * 随机土味情话
     * @param request
     * @param apiClient
     * @return
     * @throws ApiException
     */
    @Override
    public LoveResponse getRandomLoveTalk(LoveRequest request, ApiClient apiClient) throws ApiException {
        return request(apiClient,request);
    }

    /**
     * 获取随机笑话
     * @param request
     * @return
     * @throws ApiException
     */
    @Override
    public JokeResponse getRandomJoke(JokeRequest request) throws ApiException {
        return request(request);
    }

    /**
     * 获取随机笑话
     * @param request
     * @param apiClient
     * @return
     * @throws ApiException
     */
    @Override
    public JokeResponse getRandomJoke(JokeRequest request, ApiClient apiClient) throws ApiException {
        return request(apiClient,request);
    }
}
