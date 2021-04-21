package com.zs.erh.dao;

import com.zs.erh.bean.Sro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SroDao extends JpaRepository<Sro, Long> {
    public List<Sro> findAll();

    public Sro findByCode(String code);
    //public List<Sro>findByNroCode(String code);

}