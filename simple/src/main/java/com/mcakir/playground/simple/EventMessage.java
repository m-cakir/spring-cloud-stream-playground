package com.mcakir.playground.simple;

import lombok.Data;

import java.time.Instant;

@Data
public class EventMessage {

    private String id;

    private String username;

    private String message;

    private long createTime = Instant.now().toEpochMilli();

}
