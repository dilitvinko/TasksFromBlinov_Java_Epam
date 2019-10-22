package chapter_11.task_A_4_bad;

public class Operator extends Thread {

    private WaitQueue waitQueue;

    public Operator(WaitQueue waitQueue) {
        this.waitQueue = waitQueue;
    }

    @Override
    public void run() {
        //правильно ли использовать while или надо новые потоки создавать
        try {
        Thread.sleep(600);
        } catch (InterruptedException ie) {
            System.err.println(ie.getMessage());
        }
        while (!waitQueue.getClientsInWait().isEmpty()) {
            Client client = waitQueue.getClientsInWait().poll();
            Client.interrupted();
            System.out.println("Operator start talk with Client #" + client.getIdClient());
            try {
                Thread.sleep(client.getTimeSpeak());
                System.out.println("Operator END talk #" + client.getIdClient() + "  (" + client.getTimeSpeak() + "msec)");
                Thread.sleep(300);
            } catch (InterruptedException ie) {
                System.err.println(ie.getMessage());
            }

        }
    }
}
