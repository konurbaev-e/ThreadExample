package org.konurbaev;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.LinkedTransferQueue;

class Queue {
    private final LinkedTransferQueue<Integer> transferQueue = new LinkedTransferQueue<>();
    private final static Logger logger = LoggerFactory.getLogger(Queue.class);

    public void get(){
        logger.debug("Queue.get is starting");
        Integer n = null;
        try {
            n = transferQueue.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        logger.debug("Queue.get: got: " + n);
    }

    public void put(Integer n){
        logger.debug("Queue.put is starting");
        transferQueue.put(n);
        logger.debug("Queue.put: put: " + n);
    }

}
