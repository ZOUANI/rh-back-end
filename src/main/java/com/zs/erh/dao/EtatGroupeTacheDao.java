package com.zs.erh.dao;

import com.zs.erh.bean.EtatGroupeTache;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EtatGroupeTacheDao extends JpaRepository<EtatGroupeTache, Long> {
     public List<EtatGroupeTache> findAll();
     public EtatGroupeTache findByCode(String code);
}
