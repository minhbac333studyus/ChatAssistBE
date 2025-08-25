package com.chatassistbe.repository;

import com.chatassistbe.entity.MessageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepo  extends JpaRepository<MessageEntity, Long> {
    List<MessageEntity> findByConversationIdOrderByIdAsc(Long conversationId);
}
