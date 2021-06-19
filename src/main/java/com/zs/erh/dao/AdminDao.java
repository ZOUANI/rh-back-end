package com.zs.erh.dao;

import com.zs.erh.bean.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdminDao extends JpaRepository<Admin, Long> {

    Optional<Admin> findByLogin (String login);

    Boolean existsByLogin(String login);

    Boolean existsByEmail(String email);
}
