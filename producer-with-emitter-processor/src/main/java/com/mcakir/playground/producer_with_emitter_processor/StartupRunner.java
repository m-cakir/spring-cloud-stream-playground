package com.mcakir.playground.producer_with_emitter_processor;

import com.mcakir.playground.producer_with_emitter_processor.domain.EventMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;
import reactor.core.publisher.EmitterProcessor;

@Service
@Slf4j
@RequiredArgsConstructor
public class StartupRunner implements CommandLineRunner {

    private final EmitterProcessor<EventMessage> messageProcessor;

    @Override
    public void run(String... args) throws Exception {

        EventMessage event = new EventMessage();
        event.setUsername("Heisenberg");
        event.setMessage("say my name");

        log.info("event-message will be sent to kafka, event={}", event);

        messageProcessor.onNext(event);
    }
}
