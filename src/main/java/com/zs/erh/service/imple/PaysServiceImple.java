package com.zs.erh.service.imple;

import com.zs.erh.bean.Pays;
import com.zs.erh.dao.PaysDao;
import com.zs.erh.service.facade.PaysService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class PaysServiceImple implements PaysService {
    @Autowired
    private PaysDao paysDao;

    public Pays findByCode(String code) {
        return paysDao.findByCode(code);
    }

    public Optional<Pays> findById(Long id) {
        return paysDao.findById(id);
    }
    @Transactional
    public int deleteByCode(String code) {
        return paysDao.deleteByCode(code);
    }

    public List<Pays> findAll() {
        return paysDao.findAll();
    }

    public Pays save(Pays pays) {
        if(findByCode(pays.getCode())!=null){
            return  null;
        }else{
            paysDao.save(pays);
            return pays;
        }
    }

    public Pays update(Pays pays){
       paysDao.save(pays);
       return pays;
    }
}
