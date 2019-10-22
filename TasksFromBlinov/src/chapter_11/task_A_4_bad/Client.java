package chapter_11.task_A_4_bad;

import java.util.concurrent.Semaphore;

public class Client extends Thread {
    private int idClient;
    private int timeSpeak;
    private int timeCanWait;

    private final static int POOL_SIZE = 1; // размер пула
    private final Semaphore semaphore = new Semaphore(POOL_SIZE, true);

    @Override
    public void run() {
        System.out.println("Client #" + idClient + " start wait in WaitQueue");
        try {
            this.join(timeCanWait);
            WaitQueue.clientsInWait.remove(this);
            System.out.println("Client #" + idClient + " end wait in WaitQueue (" + timeCanWait + " msec)");
            Thread.sleep(1500);
            WaitQueue.clientsInWait.add(this);
        }catch (InterruptedException ie){
            System.err.println(ie.getMessage());
        }

    }


    public Client(int idClient, int timeSpeak, int timeCanWait) {
        this.idClient = idClient;
        this.timeSpeak = timeSpeak;
        this.timeCanWait = timeCanWait;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public int getTimeSpeak() {
        return timeSpeak;
    }

    public void setTimeSpeak(int timeSpeak) {
        this.timeSpeak = timeSpeak;
    }

    public int getTimeCanWait() {
        return timeCanWait;
    }

    public void setTimeCanWait(int timeCanWait) {
        this.timeCanWait = timeCanWait;
    }

    @Override
    public String toString() {
        return idClient + " " + timeSpeak + " " + timeCanWait;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!Client.class.isAssignableFrom(obj.getClass())) {
            return false;
        }
        final Client other = (Client) obj;

        if (this.idClient != other.idClient) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
