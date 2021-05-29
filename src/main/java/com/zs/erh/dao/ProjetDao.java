package com.zs.erh.dao;


import com.zs.erh.bean.Projet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProjetDao extends JpaRepository<Projet, Long> {
    public List<Projet> findByClientId(Long id);
    public List<Projet> findAll();
    public Projet findByCode(String code);
    public int deleteByCode(String code);


    // TODO Msh 3ad Zmr !!!!!! ASAHBI dir findById
    @Query("SELECT p FROM Projet p WHERE p.id = :id")
     Projet findId(@Param("id") Long id);
}