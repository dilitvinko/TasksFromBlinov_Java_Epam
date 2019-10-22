package onlyTests.threads.atomic;

import java.util.Random;
public class Broker extends Thread {
    private Market market;
    private static final int PAUSE = 1000; // in millis
    public Broker(Market market) {
        this.market = market;
    }
    @Override
    public void run() {
        try {
            while (true) {
                System.out.println("Current index: " + market.getIndex());
                Thread.sleep(PAUSE);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
