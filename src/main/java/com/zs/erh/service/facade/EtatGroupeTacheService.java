package com.zs.erh.service.facade;

import com.zs.erh.bean.EtatGroupeTache;
import java.util.List;

public interface EtatGroupeTacheService {
    public List<EtatGroupeTache> findAll();
    public EtatGroupeTache findByCode(String code);

}
