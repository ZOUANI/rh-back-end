package com.zs.erh.dao;
import com.zs.erh.bean.Client;
import com.zs.erh.bean.Collaborateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientDao extends JpaRepository<Client,Long> {
     List<Client> findAll();
    List<Client> findByEntrepriseLibelle(String libelle);
    int deleteByEntrepriseLibelle(String libelle);
    int deleteByLibelle (String libelle);
}