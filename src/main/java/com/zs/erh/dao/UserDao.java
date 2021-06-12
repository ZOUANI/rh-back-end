package com.zs.erh.dao;

import com.zs.erh.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserDao extends JpaRepository<User, Long> {
    Optional<User> findByLogin(String login);

    Boolean existsByLogin(String login);

    Boolean existsByEmail(String email);
}
