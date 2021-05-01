package com.zs.erh.service.imple;

import com.zs.erh.bean.Periode;
import com.zs.erh.dao.PeriodeDao;
import com.zs.erh.service.facade.PeriodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PeriodeServiceImple implements PeriodeService {
    @Autowired
    private PeriodeDao periodeDao;

    public List<Periode> findAll() {
        return periodeDao.findAll();
    }

    public Periode findByCode(String code) {
        return periodeDao.findByCode(code);
    }
}
