package com.zs.erh.service.facade;

import com.zs.erh.bean.Lot;

import java.util.List;

public interface LotService {
    public List<Lot> findByProjetCode(String code);

    public List<Lot> findByProjetId(Long id);

    public List<Lot> findByProjetIdAndResponsableCode(Long id, String code);

    public Lot findByCode(String code);

    public List<Lot> findByProjetAgenceChefAgenceCode(String code);

    public List<Lot> findByResponsableCode(String code);

    public List<Lot> findAll();

    public int deleteByCode(String code);

    int deleteMultiple(List<Lot> lots);

    public int deleteByProjetCode(String code);

    public Lot save(Lot lot);

    int updateLot(Lot lot);

}
