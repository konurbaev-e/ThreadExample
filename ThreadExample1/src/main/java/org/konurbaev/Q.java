package org.konurbaev;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Q {
    private volatile int n;
    private volatile boolean valueSet = false;
    private final static Logger logger = LoggerFactory.getLogger(Q.class);

    public synchronized int get(){
        logger.debug("Q.get is starting; valueSet = " + valueSet);
        while (!valueSet)
            try {
                logger.debug("Q.get: start waiting; valueSet = " + valueSet);
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        valueSet = false;
        logger.debug("Q.get: got: " + n + "; valueSet = " + valueSet);
        notify();
        return n;
    }

    public synchronized void put(int n){
        logger.debug("Q.put is starting; valueSet = " + valueSet);
        while (valueSet)
            try {
                logger.debug("Q.put: start waiting; valueSet = " + valueSet);
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        this.n = n;
        valueSet = true;
        logger.debug("Q.put: put: " + n + "; valueSet = " + valueSet);
        notify();
    }

}
