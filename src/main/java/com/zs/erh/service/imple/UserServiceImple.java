package com.zs.erh.service.imple;

import com.zs.erh.bean.User;
import com.zs.erh.dao.UserDao;
import com.zs.erh.service.facade.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImple  implements UserService {
    @Autowired
    private UserDao userDao;

    public Optional<User> findByLogin(String login) {
        return userDao.findByLogin(login);
    }
}
