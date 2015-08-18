package org.konurbaev;


public class Producer implements Runnable {
    Q q;

    Producer(Q q) {
        System.out.println("Producer.constructor is starting");
        this.q = q;
        new Thread(this, "ProducerThread").start();
    }

    @Override
    public void run() {
        int i = 0;

        while (true) {
            System.out.println("Producer.run: in while cycle");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            q.put(i++);
        }
    }
}
