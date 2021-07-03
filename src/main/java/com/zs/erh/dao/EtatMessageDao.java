package com.zs.erh.dao;

import com.zs.erh.bean.EtatMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EtatMessageDao extends JpaRepository<EtatMessage,Long> {
    EtatMessage findByCode(String code);
    public List<EtatMessage> findAll();
    Optional<EtatMessage> findById(Long id);
}
