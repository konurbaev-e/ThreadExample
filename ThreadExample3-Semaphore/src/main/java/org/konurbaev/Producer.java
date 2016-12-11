package org.konurbaev;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class Producer implements Runnable {
    private final Queue queue;
    private final static Logger logger = LoggerFactory.getLogger(Producer.class);

    Producer(Queue queue) {
        logger.debug("Producer.constructor is starting");
        this.queue = queue;
        new Thread(this, "ProducerThread").start();
    }

    @Override
    public void run() {
        Integer i = 0;

        while (true) {
            logger.debug("Producer.run: in while cycle");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            queue.put(i++);
        }
    }
}
