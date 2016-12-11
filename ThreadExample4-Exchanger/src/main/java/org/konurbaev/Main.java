package org.konurbaev;

import java.util.concurrent.Exchanger;

class Main {
    public static void main (String args[]) {
        Exchanger<String> exchanger = new Exchanger<>();
        new Producer(exchanger);
        new Consumer(exchanger);
    }
}
