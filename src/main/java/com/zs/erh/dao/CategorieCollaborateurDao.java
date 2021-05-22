package com.zs.erh.dao;

import com.zs.erh.bean.CategorieCollaborateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategorieCollaborateurDao  extends JpaRepository<CategorieCollaborateur, Long> {
    public CategorieCollaborateur findByCode(String code);
}
