package com.mcakir.playground.simple_producer.domain;

import lombok.Data;

@Data
public class EventMessage {

    private String username;

    private String message;

    private long createTime = System.currentTimeMillis();

}
