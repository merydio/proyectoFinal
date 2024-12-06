package com.queueapp.model;

import java.util.LinkedList;
import java.util.Queue;

public class QueueServer {
    private static QueueServer instance;
    private Queue<Person> queue;
    private final int maxSize;

    private QueueServer() {
        this.maxSize = 10; // Default max size
        this.queue = new LinkedList<>();
    }

    public static QueueServer getInstance() {
        if (instance == null) {
            instance = new QueueServer();
        }
        return instance;
    }

    public synchronized boolean addPerson(Person person) {
        if (queue.size() < maxSize) {
            queue.offer(person);
            return true;
        }
        return false;
    }

    public synchronized Person getNextPerson() {
        return queue.poll();
    }

    public synchronized int getQueueSize() {
        return queue.size();
    }

    public int getMaxSize() {
        return maxSize;
    }
}