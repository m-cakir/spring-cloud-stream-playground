package com.mcakir.playground.simple;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.Message;

import java.util.function.Consumer;

@Configuration
@Slf4j
public class ConsumerConfiguration {

    @Bean
    public Consumer<Message<EventMessage>> messageConsumer() {
        return payload -> log.info("[consumed] event-message ::: {}", payload);
    }

}
