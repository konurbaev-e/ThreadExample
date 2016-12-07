package konurbaev;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.LinkedTransferQueue;

class Q {
    private LinkedTransferQueue<Integer> transferQueue = new LinkedTransferQueue();
    private final static Logger logger = LoggerFactory.getLogger(Q.class);

    public void get(){
        logger.debug("Q.get is starting");
        Integer n = null;
        try {
            n = transferQueue.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        logger.debug("Q.get: got: " + n);
    }

    public void put(Integer n){
        logger.debug("Q.put is starting");
        transferQueue.put(n);
        logger.debug("Q.put: put: " + n);
    }

}
