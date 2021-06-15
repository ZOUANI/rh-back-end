package com.zs.erh.service.facade;

import com.zs.erh.bean.User;

import java.util.Optional;

public interface UserService {
     Optional<User> findByLogin(String login);
}
