package com.zs.erh.service.facade;


import com.zs.erh.bean.Client;
import com.zs.erh.bean.Entreprise;
import com.zs.erh.service.vo.ClientVO;

import java.util.List;
import java.util.Optional;

public interface ClientService {
    List<Client> findByEntrepriseCode(String code);
    int deleteByEntrepriseCode(String code);
    Client save(Client client);
    List<Client> search(ClientVO clientVO);
    int deleteByCode(String code);
    int deleteByCode(List<Client> clients);
    Optional<Client> findById(Long id);
    Client update(Client client);
    Client findByCode(String code);
    List<Client> findAll();


}