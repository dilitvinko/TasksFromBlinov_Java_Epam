package chapter_11.task_A_4_bad;

import java.util.LinkedList;
import java.util.Queue;

public class WaitQueue {

    public static final Queue<Client> clientsInWait = new LinkedList<Client>();

    public WaitQueue(LinkedList<Client> queue) {
        clientsInWait.addAll(queue);
    }

    public Queue<Client> getClientsInWait() {
        return clientsInWait;
    }
}
