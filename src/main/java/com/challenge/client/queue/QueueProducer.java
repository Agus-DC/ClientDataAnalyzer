package com.challenge.client.queue;

@FunctionalInterface
public interface QueueProducer {
    void sendMessage(String message);
}
