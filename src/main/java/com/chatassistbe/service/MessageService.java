package com.chatassistbe.service;

import com.chatassistbe.entity.MessageEntity;
import com.chatassistbe.repository.MessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {
    @Autowired
    MessageRepo messageRepo;

    public List<MessageEntity> findByConversationIdOrderByIdAsc(Long conversationId) {
        return messageRepo.findByConversationIdOrderByIdAsc(conversationId);
    }
    public void saveMessage(MessageEntity messageEntity) {
        messageRepo.save(messageEntity);
    }
}
