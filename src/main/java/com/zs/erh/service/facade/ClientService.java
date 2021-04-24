package com.zs.erh.service.facade;

import com.zs.erh.bean.Client;
import com.zs.erh.bean.Entreprise;
import com.zs.erh.vo.ClientVO;

import java.util.List;

public interface ClientService {
    List<Client> findByEntrepriseLibelle(String libelle);
    int deleteByEntrepriseLibelle(String libelle);
    void save(Entreprise entreprise, List<Client> clients);
    int deleteByLibelle(String libelle);
    List<Client> search(ClientVO clientVO);
}
