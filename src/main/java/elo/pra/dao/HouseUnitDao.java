package elo.pra.dao;

import elo.pra.vo.HouseUnit;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Joshua.H.Brooks
 * @description
 * @date 2024-06-11 20:29
 */
@Mapper
public interface HouseUnitDao {
    /**
     * 将每个房间的销售状态批量插入表
     * @param units
     */
    public void insertBatch(@Param("units") List<HouseUnit> units);
    public List<HouseUnit> getbyPresale(@Param("presalePermitNumber") String presaleCertId);

}

