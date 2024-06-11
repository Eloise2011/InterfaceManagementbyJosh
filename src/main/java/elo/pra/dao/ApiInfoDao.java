package elo.pra.dao;

/**
 * @author Joshua.H.Brooks
 * @description
 * @date 2024-05-15 23:49
 */

import elo.pra.vo.ApiInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


@Mapper
public interface ApiInfoDao {
    List<ApiInfo> search(@Param("key") String key, @Param("bdIdentify") String bdIdentify);
}
