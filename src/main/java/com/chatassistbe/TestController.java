package com.chatassistbe;

import com.chatassistbe.entity.MessageEntity;
import com.chatassistbe.service.ConversationService;
import com.chatassistbe.service.MessageService;
import com.chatassistbe.service.UserService;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/test")
public class TestController {
    @Autowired
    MessageService messageService;
    @Autowired
    UserService userService;
    @Autowired
    ConversationService conversationService;
    @GetMapping()
    public String test() {
        return "Hello World!";
    }

    @GetMapping(value = "/messages", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody()
    public List<MessageEntity> testGetAllMessage() {
        System.out.println("messageService.findByConversationIdOrderByIdAsc((1L)) = " + messageService.findByConversationIdOrderByIdAsc((1L)));
        return messageService.findByConversationIdOrderByIdAsc(1L);
    }
}
