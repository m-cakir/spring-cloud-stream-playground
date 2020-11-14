package com.mcakir.playground.simple_producer.producer;

import com.mcakir.playground.simple_producer.domain.EventMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Supplier;

@Configuration
@Slf4j
public class ProducerConfiguration {

    @Bean
    public Supplier<EventMessage> messageProducer() {
        return () -> {
            EventMessage event = new EventMessage();
            event.setUsername("Heisenberg");
            event.setMessage("say my name");

            log.info("event-message will be sent to kafka ::: event={}", event);

            return event;
        };
    }

}
