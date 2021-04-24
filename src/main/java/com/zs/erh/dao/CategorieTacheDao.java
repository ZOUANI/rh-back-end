package com.zs.erh.dao;

import com.zs.erh.bean.CategorieTache;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategorieTacheDao extends JpaRepository<CategorieTache, Long> {

    public List<CategorieTache> findAll();
    public CategorieTache findByCode(String code);

}
