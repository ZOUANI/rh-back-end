package com.zs.erh.service.facade;

import com.zs.erh.bean.Lot;

import java.util.List;

public interface LotService {
    public List<Lot> findByProjetCode(String code);

    public Lot findByCode(String code);

    public List<Lot> findAll();

    public List<Lot> findBySroCode(String code);

    public int deleteByCode(String code);

    public int deleteByProjetCode(String code);

    public int save(Lot lot);
}
