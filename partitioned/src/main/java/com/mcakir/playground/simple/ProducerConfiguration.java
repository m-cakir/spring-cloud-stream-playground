package com.mcakir.playground.simple;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Random;
import java.util.UUID;
import java.util.function.Supplier;

@Configuration
@Slf4j
public class ProducerConfiguration {

    @Bean
    public Supplier<EventMessage> messageProducer() {
        return () -> {

            EventMessage event = new EventMessage();
            event.setId(UUID.randomUUID().toString());
            event.setUsername(new Random().nextBoolean() ? "heisenberg" : "mcakir");
            event.setMessage("say my name");

            log.info("[produced] event-message ::: event={}", event);

            return event;
        };
    }

}
