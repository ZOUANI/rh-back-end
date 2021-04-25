package com.zs.erh.service.imple;

import com.zs.erh.bean.EtatGroupeTache;
import com.zs.erh.dao.EtatGroupeTacheDao;
import com.zs.erh.service.facade.EtatGroupeTacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EtatGroupeTacheImple implements EtatGroupeTacheService {
    @Autowired
    public EtatGroupeTacheDao etatGroupeTacheDao;

    @Override
    public List<EtatGroupeTache> findAll() {
        return etatGroupeTacheDao.findAll();
    }
}
