package org.konurbaev;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class Queue {
    private volatile int n;
    private volatile boolean valueSet = false;
    private final static Logger logger = LoggerFactory.getLogger(Queue.class);

    public synchronized void get(){
        logger.debug("Queue.get is starting; valueSet = " + valueSet);
        while (!valueSet)
            try {
                logger.debug("Queue.get: start waiting; valueSet = " + valueSet);
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        valueSet = false;
        logger.debug("Queue.get: got: " + n + "; valueSet = " + valueSet);
        notify();
    }

    public synchronized void put(int n){
        logger.debug("Queue.put is starting; valueSet = " + valueSet);
        while (valueSet)
            try {
                logger.debug("Queue.put: start waiting; valueSet = " + valueSet);
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        this.n = n;
        valueSet = true;
        logger.debug("Queue.put: put: " + n + "; valueSet = " + valueSet);
        notify();
    }

}
