package com.zs.erh.service.imple;

import com.zs.erh.bean.Nro;
import com.zs.erh.dao.NroDao;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class NroServiceImpl {
    public List<Nro> findAll() {
        return nroDao.findAll();
    }

    public Nro findByCode(String Code) {
        return nroDao.findByCode(Code);
    }

    public int deleteByCode(String code) {
        return nroDao.deleteByCode(code);
    }

    @Autowired
    public NroDao nroDao;
}
