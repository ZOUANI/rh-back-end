package com.zs.erh.service.facade;
import com.zs.erh.bean.Paiement;
import com.zs.erh.service.vo.PaiementVO;

import java.util.List;

public interface PaiementService {
    public List<Paiement> findAll();
    public Paiement findByReference(String reference);
    public List<Paiement> findByFactureCode(String code);
    public int save(Paiement paiement);
    public int updatePaiement(Paiement paiement);
    public int deleteByReference(String reference);
    public int deleteByFactureCode(String code);
    public int deleteMultiple(List<Paiement> paiements);
    public PaiementVO calcStatistiquePaiement(PaiementVO paiementVO);
}
