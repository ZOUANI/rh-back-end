package com.zs.erh.dao;

import com.zs.erh.bean.CategorieGroupeTache;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CategorieGroupeTacheDao extends JpaRepository<CategorieGroupeTache, Long> {
    public List<CategorieGroupeTache> findAll();
    public CategorieGroupeTache findByCode(String code);
}
