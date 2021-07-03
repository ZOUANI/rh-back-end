package com.zs.erh.service.facade;

import com.zs.erh.bean.User;

import java.util.Optional;

public interface UserService {
     Optional<User> findByLogin(String login);

     Optional<User> findById(Long id);
     public User save(User user);
     public User editePersonnel(User user);
     int block(Long id);
     int reset(Long id);
     int deblock(Long id);
     }
