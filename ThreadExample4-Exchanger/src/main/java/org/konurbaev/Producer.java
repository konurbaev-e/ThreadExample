package org.konurbaev;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.Exchanger;

class Producer implements Runnable {
    private final Exchanger<String> exchanger;
    private final static Logger logger = LoggerFactory.getLogger(Producer.class);

    Producer(Exchanger<String> exchanger) {
        logger.debug("Producer.constructor is starting");
        this.exchanger = exchanger;
        new Thread(this, "ProducerThread").start();
    }

    @Override
    public void run() {
        int i = 0;

        while (true) {
            logger.debug("Producer.run: in while cycle");
            try {
                Thread.sleep(1000);
                String str = String.valueOf(i++);
                logger.debug("Producer.run: exchanger set: " + str);
                exchanger.exchange(str);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
