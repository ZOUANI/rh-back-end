package com.zs.erh.service.imple;

import com.zs.erh.bean.User;
import com.zs.erh.dao.UserDao;
import com.zs.erh.service.facade.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImple  implements UserService {
    @Autowired
    private UserDao userDao;

    public Optional<User> findByLogin(String login) {
        return userDao.findByLogin(login);
    }

    public Optional<User> findById(Long id){
        return userDao.findById(id);
    }

    public User save(User user){
        return userDao.save(user);
    }

    public User editePersonnel(User user){
        Optional<User> userFounded = userDao.findById(user.getId());
        if(userFounded.isPresent()){
            userFounded.get().setNom(user.getNom());
            userFounded.get().setPrenom(user.getPrenom());
            userFounded.get().setLogin(user.getLogin());
            userFounded.get().setPhone(user.getPhone());
            userDao.save(userFounded.get());
            return userFounded.get();
        }else
            return null;
    }
}
