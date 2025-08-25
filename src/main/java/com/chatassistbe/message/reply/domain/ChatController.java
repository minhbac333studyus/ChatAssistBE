package com.chatassistbe.message.reply.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.codec.ServerSentEvent;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/chat")
public class ChatController {
    @Autowired
    ChatService chatService;
    @GetMapping(value = "/{cid}", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<ServerSentEvent<String>> ask(@PathVariable("cid") Long cid, @RequestParam  String content) {

        return chatService.replyBackFromBot(cid,content).map(token -> ServerSentEvent.<String>builder().event("delta").data(token).build()
                );
    }
}
