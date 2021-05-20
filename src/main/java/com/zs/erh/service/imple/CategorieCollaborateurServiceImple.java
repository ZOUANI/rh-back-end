package com.zs.erh.service.imple;

import com.zs.erh.bean.CategorieCollaborateur;
import com.zs.erh.dao.CategorieCollaborateurDao;
import com.zs.erh.service.facade.CategorieCollaborateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategorieCollaborateurServiceImple implements CategorieCollaborateurService {
    @Autowired
    private CategorieCollaborateurDao categorieCollaborateurDao;

    public CategorieCollaborateur findByCode(String code) {
        return categorieCollaborateurDao.findByCode(code);
    }
}
