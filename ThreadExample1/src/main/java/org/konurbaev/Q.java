package org.konurbaev;

public class Q {
    private volatile int n;
    private volatile boolean valueSet = false;

    public synchronized int get(){
        System.out.println("Q.get is starting; valueSet = " + valueSet);
        while (!valueSet)
            try {
                System.out.println("Q.get: start waiting; valueSet = " + valueSet);
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        valueSet = false;
        System.out.println("Q.get: got: " + n + "; valueSet = " + valueSet);
        notify();
        return n;
    }

    public synchronized void put(int n){
        System.out.println("Q.put is starting; valueSet = " + valueSet);
        while (valueSet)
            try {
                System.out.println("Q.put: start waiting; valueSet = " + valueSet);
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        this.n = n;
        valueSet = true;
        System.out.println("Q.put: put: " + n + "; valueSet = " + valueSet);
        notify();
    }

}
