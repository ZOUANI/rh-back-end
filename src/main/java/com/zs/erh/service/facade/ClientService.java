package com.zs.erh.service.facade;


import com.zs.erh.bean.Client;
import com.zs.erh.bean.Entreprise;
import com.zs.erh.vo.ClientVO;

import java.util.List;
import java.util.Optional;

public interface ClientService {
    List<Client> findByEntrepriseLibelle(String libelle);
    List<Client> findAll();
    int deleteByEntrepriseLibelle(String libelle);
    List<Client> findByEntrepriseCode(String code);
    int deleteByEntrepriseCode(String code);
    void save(Entreprise entreprise, List<Client> clients);
    List<Client> search(ClientVO clientVO);
    int deleteByCode(String code);
    Optional<Client> findById(Long id);

}
