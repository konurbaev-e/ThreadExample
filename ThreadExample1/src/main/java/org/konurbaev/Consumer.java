package org.konurbaev;

public class Consumer implements Runnable{
    Q q;

    Consumer(Q q) {
        System.out.println("Consumer.constructor is running");
        this.q = q;
        new Thread(this, "ConsumerThread").start();
    }

    @Override
    public void run() {
        while (true) {
            System.out.println("Consumer.run: in while cycle");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            q.get();
        }
    }
}
