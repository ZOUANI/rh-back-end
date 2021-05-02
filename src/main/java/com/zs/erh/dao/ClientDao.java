package com.zs.erh.dao;
import com.zs.erh.bean.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClientDao extends JpaRepository<Client,Long> {
    List<Client> findByEntrepriseCode(String code);
    int deleteByEntrepriseCode(String code);
    int deleteByCode (String code);
    Optional<Client> findById(Long id);
    Client findByCode(String code);

}