package com.zs.erh.dao;

import com.zs.erh.bean.MessageDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface MessageDetailDao extends JpaRepository<MessageDetail,Long> {
	List<MessageDetail> findByMessageId(Long id);
    List<MessageDetail> findAll();
    
}
