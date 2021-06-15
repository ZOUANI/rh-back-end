package com.zs.erh.service.imple;

import com.zs.erh.bean.EtatMessage;
import com.zs.erh.dao.EtatMessageDao;
import com.zs.erh.service.facade.EtatMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EtatMessageServiceImple implements EtatMessageService {
    @Autowired
    private EtatMessageDao etatMessageDao;

    public EtatMessage findByCode(String code) {
        return etatMessageDao.findByCode(code);
    }

    public Optional<EtatMessage> findById(Long id) {
        return etatMessageDao.findById(id);
    }

    public List<EtatMessage> findAll() {
        return etatMessageDao.findAll();
    }
}
