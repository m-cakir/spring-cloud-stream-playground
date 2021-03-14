package com.mcakir.playground.producer_with_emitter_processor;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.EmitterProcessor;

@RestController
@RequestMapping("api")
@Slf4j
@RequiredArgsConstructor
public class ApiController {
    private final EmitterProcessor<EventMessage> messageProcessor;

    @GetMapping
    public ResponseEntity<?> get(@RequestParam String username) {

        EventMessage event = new EventMessage();
        event.setUsername(username);
        event.setMessage("say my name");

        log.info("event-message will be sent to kafka ::: event={}", event);

        messageProcessor.onNext(event);

        return ResponseEntity.ok(event);
    }

}
