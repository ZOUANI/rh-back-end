package com.zs.erh.dao;
import com.zs.erh.bean.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientDao extends JpaRepository<Client,Long> {
    List<Client> findByEntrepriseLibelle(String libelle);
    int deleteByEntrepriseLibelle(String libelle);
    int deleteByLibelle (String libelle);
}