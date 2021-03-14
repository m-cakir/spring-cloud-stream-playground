package com.mcakir.playground.dlq;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.Message;

import java.nio.charset.StandardCharsets;
import java.util.Objects;
import java.util.function.Consumer;

import static org.springframework.cloud.stream.binder.kafka.KafkaMessageChannelBinder.*;

@Configuration
@Slf4j
public class ConsumerConfiguration {

    @Bean
    public Consumer<EventMessage> messageConsumer() {
        return payload -> {

            if ("Heisenberg".equalsIgnoreCase(payload.getUsername())) {
                throw new RuntimeException("username is Heisenberg");
            }

            log.info("[consumed] event-message ::: {}", payload);
        };
    }

    @Bean
    public Consumer<Message<?>> dlqConsumer() {
        return failed -> {

            log.info("[failed] event-message ::: payload={}", failed.getPayload());
            log.info("[failed] event-message ::: headers={}", failed.getHeaders());
            log.info("[failed] event-message ::: headers.original-topic={}", new String(Objects.requireNonNull(failed.getHeaders().get(X_ORIGINAL_TOPIC, byte[].class)), StandardCharsets.UTF_8));
            log.info("[failed] event-message ::: headers.exception-fqcn={}", new String(Objects.requireNonNull(failed.getHeaders().get(X_EXCEPTION_FQCN, byte[].class)), StandardCharsets.UTF_8));
            log.info("[failed] event-message ::: headers.exception-message={}", new String(Objects.requireNonNull(failed.getHeaders().get(X_EXCEPTION_MESSAGE, byte[].class)), StandardCharsets.UTF_8));
            log.info("[failed] event-message ::: headers.exception-stacktrace={}", new String(Objects.requireNonNull(failed.getHeaders().get(X_EXCEPTION_STACKTRACE, byte[].class)), StandardCharsets.UTF_8));
        };
    }

}
