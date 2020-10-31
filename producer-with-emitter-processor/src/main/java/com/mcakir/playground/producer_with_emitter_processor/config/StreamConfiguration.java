package com.mcakir.playground.producer_with_emitter_processor.config;

import com.mcakir.playground.producer_with_emitter_processor.domain.EventMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.EmitterProcessor;
import reactor.core.publisher.Flux;

import java.util.function.Supplier;

@Configuration
@Slf4j
public class StreamConfiguration {

    @Bean
    public EmitterProcessor<EventMessage> messageProcessor() {
        return EmitterProcessor.create();
    }

    @Bean
    public Supplier<Flux<EventMessage>> messageProducer() {
        return this::messageProcessor;
    }

}
