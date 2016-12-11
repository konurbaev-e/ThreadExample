package org.konurbaev;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.Exchanger;

class Consumer implements Runnable{
    private final Exchanger<String> exchanger;
    private final static Logger logger = LoggerFactory.getLogger(Consumer.class);

    Consumer(Exchanger<String> exchanger) {
        logger.debug("Consumer.constructor is running");
        this.exchanger = exchanger;
        new Thread(this, "ConsumerThread").start();
    }

    @Override
    public void run() {
        while (true) {
            logger.debug("Consumer.run: in while cycle");
            try {
                Thread.sleep(1000);
                logger.debug("Consumer.run: exchanger get: " + exchanger.exchange(""));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
