package com.zs.erh.dao;


import com.zs.erh.bean.GroupeTache;
import com.zs.erh.bean.Nro;
import com.zs.erh.bean.Projet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjetDao extends JpaRepository<Projet, Long> {

    public List<Projet> findByNroCode(String code);
    public List<Projet> findAll();
    public List<GroupeTache> findByLotCode(String code);
    public Projet findByCode(String code);
    public int deleteByCode(String code);
    public int deleteByNroCode(String code);

}