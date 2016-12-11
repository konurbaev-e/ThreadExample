package org.konurbaev;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.Semaphore;

class Queue {

    private final static Logger logger = LoggerFactory.getLogger(Queue.class);

    private int n;

    private static final Semaphore semaphoreConsumer = new Semaphore(0);
    private static final Semaphore semaphoreProducer = new Semaphore(1);

    public void get(){
        logger.debug("Queue.get is starting");
        try {
            semaphoreConsumer.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        logger.debug("Queue.get: got: " + n);
        semaphoreProducer.release();
    }

    public void put(int n){
        logger.debug("Queue.put is starting");
        try {
            semaphoreProducer.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.n = n;
        logger.debug("Queue.put: put: " + n);
        semaphoreConsumer.release();
    }

}
