package com.zs.erh.service.facade;

import com.zs.erh.bean.EtatMessage;

import java.util.List;
import java.util.Optional;

public interface EtatMessageService {
	
    EtatMessage findByCode(String code);
    
    Optional<EtatMessage> findById(Long id);
    
    List<EtatMessage> findAll();
}
