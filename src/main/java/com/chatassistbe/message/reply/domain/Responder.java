package com.chatassistbe.message.reply.domain;

import reactor.core.publisher.Flux;

public interface Responder {
    Flux<String> streamReply(Long conversationId, String userText);
}
