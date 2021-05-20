package com.zs.erh.dao;

import com.zs.erh.bean.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminDao extends JpaRepository<Admin, Long> {
    public Admin findByLogin(String login);
}
