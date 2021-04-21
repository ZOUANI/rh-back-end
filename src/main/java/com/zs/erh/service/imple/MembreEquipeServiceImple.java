package com.zs.erh.service.imple;

import com.zs.erh.bean.MembreEquipe;
import com.zs.erh.dao.MembreEquipeDao;
import com.zs.erh.service.facade.MembreEquipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MembreEquipeServiceImple implements MembreEquipeService {
    @Autowired
    private MembreEquipeDao membreEquipeDao;

    public List<MembreEquipe> findByCollaborateurCode(String code){
        return membreEquipeDao.findByCollaborateurCode(code);
    }

   public MembreEquipe findByEquipeCode(String code){
        return membreEquipeDao.findByEquipeCode(code);
    }
    public int deleteByEquipeCode(String code){
        return membreEquipeDao.deleteByEquipeCode(code);
    }

    public List<MembreEquipe> findAll(){
        return membreEquipeDao.findAll();
    }
}
