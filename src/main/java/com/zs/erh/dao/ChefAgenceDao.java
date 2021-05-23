package com.zs.erh.dao;

import com.zs.erh.bean.ChefAgence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ChefAgenceDao extends JpaRepository<ChefAgence,Long> {
    ChefAgence findByCode(String code);
    Optional<ChefAgence> findById(Long id);
    int deleteByCode(String code);
    //List<ChefAgence> findByLogin(String login);
    //ChefAgence findByPassword(String password);
}
