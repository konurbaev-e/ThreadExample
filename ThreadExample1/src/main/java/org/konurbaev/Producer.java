package org.konurbaev;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class Producer implements Runnable {
    private final Q q;
    private final static Logger logger = LoggerFactory.getLogger(Producer.class);

    Producer(Q q) {
        logger.debug("Producer.constructor is starting");
        this.q = q;
        new Thread(this, "ProducerThread").start();
    }

    @Override
    public void run() {
        int i = 0;

        while (true) {
            logger.debug("Producer.run: in while cycle");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            q.put(i++);
        }
    }
}
