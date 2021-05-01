package com.zs.erh.service.imple;

import com.zs.erh.bean.EtatLot;
import com.zs.erh.dao.EtatLotDao;
import com.zs.erh.service.facade.EtatLotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EtatLotServiceImple implements EtatLotService {
    @Autowired
    private EtatLotDao etatLotDao;


    public List<EtatLot> findAll() {
        return etatLotDao.findAll();
    }
}
