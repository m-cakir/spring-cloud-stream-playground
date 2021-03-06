package com.mcakir.playground.producer_with_emitter_processor;

import lombok.Data;

@Data
public class EventMessage {

    private String username;

    private String message;

    private long createTime = System.currentTimeMillis();

}
