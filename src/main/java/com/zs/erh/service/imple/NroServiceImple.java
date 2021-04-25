package com.zs.erh.service.imple;

import com.zs.erh.bean.Nro;
import com.zs.erh.dao.NroDao;
import com.zs.erh.service.facade.NroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class NroServiceImple implements NroService {
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
