package com.zs.erh.dao;

import com.zs.erh.bean.EtatFacture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EtatFactureDao extends JpaRepository<EtatFacture, Long> {

}
