package com.zs.erh.service;

import com.zs.erh.bean.MembreEquipe;
import com.zs.erh.dao.MembreEquipeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MembreEquipeService {
    @Autowired
    private MembreEquipeDao membreEquipeDao;

    public List<MembreEquipe> findAll(){
        return membreEquipeDao.findAll();
    }
}
