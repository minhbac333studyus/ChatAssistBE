package com.chatassistbe.service;

import com.chatassistbe.entity.ConversationEntity;
import com.chatassistbe.repository.ConversationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConversationService {
    @Autowired
    ConversationRepo conversationRepo;
    public ConversationEntity refById(Long id) {
        return conversationRepo.getReferenceById(id); // không query full row ngay
    }
}
