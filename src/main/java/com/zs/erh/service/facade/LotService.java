package com.zs.erh.service.facade;

import com.zs.erh.bean.Client;
import com.zs.erh.bean.Lot;
import com.zs.erh.bean.Projet;
import com.zs.erh.bean.Sro;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LotService {
    public List<Lot> findByProjetCode(String code);

    public List<Lot> findByProjetId(Long id);

    public Lot findByCode(String code);

    public List<Lot> findAll();

    public List<Sro> findBySroCode(String code);

    public int deleteByCode(String code);

    int deleteMultiple(List<Lot> lots);

    public int deleteByProjetCode(String code);

    public Lot save(Lot lot);

    int updateLot(Lot lot);

    Lot findIdLot(Long id);
}
