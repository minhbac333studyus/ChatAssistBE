    package com.chatassistbe.message.reply.domain;

    import com.chatassistbe.service.MessageService;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.context.annotation.Profile;
    import org.springframework.stereotype.Service;
    import reactor.core.publisher.Flux;

    import java.time.Duration;
    import java.util.Arrays;
    import java.util.List;

    @Profile("fake")
    @Service
    public class FakeResponder implements Responder {
        @Autowired
        private final MessageService messageService;
        @Autowired
        public FakeResponder(MessageService messageService) {
            this.messageService = messageService;
        }
        @Override
        public Flux<String> streamReply(Long conversationId, String userText) {
            String reply = "I am bot from Fake Responder. Answer for your question: "+ userText;

            //Stream by token
            List<String> tokens = Arrays.asList(reply.split("\\s+"));
            return Flux.fromIterable(tokens).delayElements(Duration.ofMillis(80))

                    .map(t->t +" ")
                    .doOnNext(System.out::print)
                    .doOnComplete(System.out::println);
        }
    }
