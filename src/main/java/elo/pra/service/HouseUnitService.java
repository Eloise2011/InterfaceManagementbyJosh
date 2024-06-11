package elo.pra.service;

import elo.pra.vo.HouseUnit;

import java.util.List;

/**
 * @author Joshua.H.Brooks
 * @description
 * @date 2024-06-11 20:34
 */
public interface HouseUnitService {
    public void insertBatch(List<HouseUnit> units);
    public List<HouseUnit> getAll(String presaleCertId);
}
