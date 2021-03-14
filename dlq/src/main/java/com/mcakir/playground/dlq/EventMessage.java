package com.mcakir.playground.dlq;

import lombok.Data;

@Data
public class EventMessage {

    private String username;

    private String message;

    private long createTime = System.currentTimeMillis();

}
