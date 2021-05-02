package com.zs.erh.service.facade;


import com.zs.erh.bean.Client;
import com.zs.erh.bean.Entreprise;
import com.zs.erh.service.vo.ClientVO;

import java.util.List;
import java.util.Optional;

public interface ClientService {
    List<Client> findByEntrepriseCode(String code);
    int deleteByEntrepriseCode(String code);
    int save(Client client);
    List<Client> search(ClientVO clientVO);
    int deleteByCode(String code);
    Optional<Client> findById(Long id);
    int updateClient(Client client);
    Client findByCode(String code);
    List<Client> findAll();


}