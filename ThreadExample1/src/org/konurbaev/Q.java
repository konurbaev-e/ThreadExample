package org.konurbaev;

public class Q {
    private int n;
    private boolean valueSet = false;

    public synchronized int get(){
        while (!valueSet)
            try {
                System.out.println("Q.get: start waiting");
                wait();
            } catch (InterruptedException e) {
                System.out.println("Q.get: exception InterruptedException catched");
            }
        System.out.println("Got: " + n);
        valueSet = false;
        notify();
        return n;
    }

    public synchronized void put(int n){
        while (valueSet)
            try {
                System.out.println("Q.put: start waiting");
                wait();
            } catch (InterruptedException e) {
                System.out.println("Q.put: exception InterruptedException catched");
            }
        this.n = n;
        valueSet = true;
        System.out.println("Got: " + n);
        notify();
    }

}
