package com.mcakir.playground.simple_consumer.domain;

import lombok.Data;

@Data
public class EventMessage {

    private String username;

    private String message;

    private long createTime = System.currentTimeMillis();

}
