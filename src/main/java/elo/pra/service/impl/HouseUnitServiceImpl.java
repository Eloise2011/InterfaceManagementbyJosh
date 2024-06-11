package elo.pra.service.impl;

import elo.pra.dao.HouseUnitDao;
import elo.pra.service.HouseUnitService;
import elo.pra.vo.HouseUnit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Joshua.H.Brooks
 * @description
 * @date 2024-06-11 20:35
 */
@Service
public class HouseUnitServiceImpl implements HouseUnitService {
    @Autowired
    private HouseUnitDao houseUnitDao;
    private final Logger logger = LoggerFactory.getLogger(HouseUnitServiceImpl.class);
    @Override
    public void insertBatch(List<HouseUnit> units) {
        System.out.println("-------------------------------- about to query from database, Persistence layer ～");
        units.forEach(System.out::println);
        houseUnitDao.insertBatch(units);
    }

    @Override
    public List<HouseUnit> getAll(String presaleCertId) {
        List<HouseUnit> houseUnits = houseUnitDao.getbyPresale(presaleCertId);
        return houseUnits;
    }
}
