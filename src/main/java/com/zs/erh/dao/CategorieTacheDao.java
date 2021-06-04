package com.zs.erh.dao;

import com.sun.xml.bind.v2.util.StackRecorder;
import com.zs.erh.bean.CategorieTache;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategorieTacheDao extends JpaRepository<CategorieTache, Long> {
     CategorieTache findByCode(String code);
     List<CategorieTache> findByCategorieGroupeTacheCode(String code);
     int deleteByCode(String code);
     int deleteByCategorieGroupeTacheCode(String code);
}
