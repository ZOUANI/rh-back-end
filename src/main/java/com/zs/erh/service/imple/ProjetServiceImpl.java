package com.zs.erh.service.imple;

import com.zs.erh.bean.GroupeTache;
import com.zs.erh.bean.Projet;
import com.zs.erh.dao.ProjetDao;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ProjetServiceImpl {
    public List<Projet> findByNroCode(String code) {
        return projetDao.findByNroCode(code);
    }

    public List<Projet> findAll() {
        return projetDao.findAll();
    }

    public List<GroupeTache> findByLotCode(String code) {
        return projetDao.findByLotCode(code);
    }

    public Projet findByCode(String code) {
        return projetDao.findByCode(code);
    }

    public int deleteByCode(String code) {
        return projetDao.deleteByCode(code);
    }

    public int deleteByNroCode(String code) {
        return projetDao.deleteByNroCode(code);
    }

    @Autowired
    public ProjetDao projetDao;
}
