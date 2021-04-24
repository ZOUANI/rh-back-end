package com.zs.erh.service.imple;

import com.zs.erh.bean.Sro;
import com.zs.erh.dao.SroDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SroServiceImple {
    @Autowired
    public SroDao sroDao;

    public List<Sro> findAll() {
        return sroDao.findAll();
    }

    public Sro findByCode(String code) {
        return sroDao.findByCode(code);
    }
}
