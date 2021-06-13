package com.zs.erh.dao;

import com.zs.erh.bean.Collaborateur;
import com.zs.erh.bean.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;
import java.util.Optional;

@Repository
public interface MessageDao extends JpaRepository<Message,Long> {
   List<Message> findBySourceCode(String code);

    @Override
    Optional<Message> findById(Long id);
}
