package com.zs.erh.dao;


import com.zs.erh.bean.Nro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NroDao extends JpaRepository<Nro, Long> {
    List<Nro> findAll();
    Nro findByCode(String Code);
    Nro findById(double id);
    int deleteByCode(String code);
}
