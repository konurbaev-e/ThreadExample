package org.konurbaev;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class Consumer implements Runnable{
    private final Q q;
    private final static Logger logger = LoggerFactory.getLogger(Consumer.class);

    Consumer(Q q) {
        logger.debug("Consumer.constructor is running");
        this.q = q;
        new Thread(this, "ConsumerThread").start();
    }

    @Override
    public void run() {
        while (true) {
            logger.debug("Consumer.run: in while cycle");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            q.get();
        }
    }
}
