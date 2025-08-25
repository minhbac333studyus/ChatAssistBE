package com.chatassistbe.message.reply.domain;

import com.chatassistbe.entity.ConversationEntity;
import com.chatassistbe.entity.MessageEntity;
import com.chatassistbe.entity.Role;
import com.chatassistbe.service.ConversationService;
import com.chatassistbe.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class ChatService {
    private final MessageService messageService;
    private final Responder responder;
    private final ConversationService conversationService;
    @Autowired
    public ChatService( MessageService messageService1, Responder responder1,ConversationService conversationService1) {
        this.messageService = messageService1;
        this.responder = responder1;
        this.conversationService =  conversationService1;
    }

    public Flux<String> replyBackFromBot(Long cid, String userText){
        ConversationEntity conversationId = conversationService.refById(cid);
        MessageEntity messageFromUser = new MessageEntity(conversationId,userText, Role.USER);
        messageService.saveMessage(messageFromUser);

        StringBuilder systemAsText = new StringBuilder(userText);


        return responder.streamReply(cid, systemAsText.toString())
                .doOnNext(systemAsText::append)
                .doFinally(signal -> {
                    MessageEntity systemMessageEntity = new MessageEntity(conversationId,systemAsText.toString(), Role.SYSTEM);
                    messageService.saveMessage(systemMessageEntity);
                });
    }
}
