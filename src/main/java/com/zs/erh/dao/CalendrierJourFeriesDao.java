package com.zs.erh.dao;

import com.zs.erh.bean.CalendrierJourFeries;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CalendrierJourFeriesDao extends JpaRepository<CalendrierJourFeries, Long> {

    public List<CalendrierJourFeries> findAll();

}
