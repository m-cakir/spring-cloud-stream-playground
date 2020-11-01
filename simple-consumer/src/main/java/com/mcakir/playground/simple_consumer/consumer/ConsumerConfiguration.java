package com.mcakir.playground.simple_consumer.consumer;

import com.mcakir.playground.simple_consumer.domain.EventMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Consumer;

@Configuration
@Slf4j
public class ConsumerConfiguration {

    @Bean
    public Consumer<EventMessage> messageConsumer() {
        return payload -> {
            log.info("event-message received ::: {}", payload);
        };
    }

}
