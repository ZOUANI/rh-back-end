package com.zs.erh.dao;

import com.zs.erh.bean.EtatLot;
import com.zs.erh.bean.EtatProjet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EtatLotDao extends JpaRepository<EtatLot, Long> {
    public List<EtatLot> findAll();
}
