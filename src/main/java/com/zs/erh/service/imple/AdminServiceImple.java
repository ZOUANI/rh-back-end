package com.zs.erh.service.imple;

import com.zs.erh.bean.Admin;
import com.zs.erh.dao.AdminDao;
import com.zs.erh.service.facade.AdminService;
import com.zs.erh.service.util.HashageUtil;
import com.zs.erh.service.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.Optional;

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

    @Override
    public Admin findByLogin(String login) {
        return adminDao.findByLogin(login);
    }

    @Override
    public Boolean existsByLogin(String login) {
        return adminDao.existsByLogin(login);
    }

    @Override
    public Boolean existsByEmail(String email) {
        return adminDao.existsByEmail(email);
    }

    @Override
    public Admin save(Admin user) {
        return adminDao.save(user);
    }

}
