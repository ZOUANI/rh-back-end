package com.zs.erh.dao;

import com.zs.erh.bean.CategorieGroupeTache;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategorieGroupeTacheDao extends JpaRepository<CategorieGroupeTache, Long> {
    CategorieGroupeTache findByCode(String code);
    int deleteByCode(String code);
    Optional<CategorieGroupeTache> findById(Long id);

}
