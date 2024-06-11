package elo.pra.service;

import elo.pra.vo.ApiInfo;

import java.util.List;

/**
 * @author Joshua.H.Brooks
 * @description
 * @date 2024-05-16 00:14
 */
public interface ApiInfoService {
    List<ApiInfo> search(String key, String bdIdentify);
}
