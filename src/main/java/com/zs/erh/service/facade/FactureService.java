package com.zs.erh.service.facade;

import com.zs.erh.bean.Facture;
import com.zs.erh.service.vo.FactureVO;

import java.util.List;

public interface FactureService {
    public List<Facture> findAll();
    public Facture findByCode(String code);
    public int save(Facture facture);
    public int deleteByCode(String code);
    public int updateFacture(Facture facture);
    public List<Facture> search(FactureVO factureVO);
}