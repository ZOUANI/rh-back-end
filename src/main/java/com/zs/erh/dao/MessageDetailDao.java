package com.zs.erh.dao;

import com.zs.erh.bean.MessageDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MessageDetailDao extends JpaRepository<MessageDetail,Long> {
    @Override
    Optional<MessageDetail> findById(Long id);
}
