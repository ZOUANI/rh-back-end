package com.zs.erh.service.imple;

import com.zs.erh.bean.Admin;
import com.zs.erh.dao.AdminDao;
import com.zs.erh.service.facade.AdminService;
import com.zs.erh.service.util.HashageUtil;
import com.zs.erh.service.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;

@Service
public class AdminServiceImple extends AbstractFacade<Admin> implements AdminService {
    @Override
    protected EntityManager getEntityManager() {
        return null;
    }

    @Override
    public Class<Admin> getEntityClass() {
        return Admin.class;
    }

    @Autowired
    private AdminDao adminDao;

    public Admin findByLogin(String login) {
        return adminDao.findByLogin(login);
    }

    public int save(Admin admin) {
        if (adminDao.findByLogin(admin.getLogin()) != null) {
            return -1;
        }
        else {
            adminDao.save(admin);
            return 1;
        }
    }

//    public int save(Admin admin) {
//        if (StringUtil.isEmpty(admin.getLogin())) {
//            return -2;
//        }
//        Admin c = findByLogin(admin.getLogin());
//        String hash = HashageUtil.sha256(admin.getPassword());
//        if (c == null) {
//            admin.setPassword(hash);
//            adminDao.save(admin);
//            return 1;
//        }
//        return -1;
//
//    }


    @Override
    public Admin SeConnecter(Admin admin) {
        Admin foundedAdmin = this.adminDao.findByLogin(admin.getLogin());
        if(foundedAdmin == null){
            return null;
        }
        if (!foundedAdmin.getPassword().equals(admin.getPassword())){
            return null;
        }else{
            return foundedAdmin;
        }
    }
}
