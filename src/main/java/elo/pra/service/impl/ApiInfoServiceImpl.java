package elo.pra.service.impl;

import elo.pra.dao.ApiInfoDao;
import elo.pra.service.ApiInfoService;
import elo.pra.vo.ApiInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author Joshua.H.Brooks
 * @description
 * @date 2024-05-16 00:14
 */
@Service
public class ApiInfoServiceImpl implements ApiInfoService {
    @Autowired
    private ApiInfoDao apiInfoDao;
    private final Logger logger = LoggerFactory.getLogger(ApiInfoServiceImpl.class);
    @Autowired
    HttpServletRequest request;
    @Autowired
    HttpServletResponse response;

    @Override
    public List<ApiInfo> search(String key, String bdIdentify) {
        return apiInfoDao.search(key, bdIdentify);
    }

}
