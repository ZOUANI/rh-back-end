package com.zs.erh.dao;

import com.zs.erh.bean.Periode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PeriodeDao extends JpaRepository<Periode, Long> {
    public List<Periode> findAll();
    public Periode findByCode(String code);
}
