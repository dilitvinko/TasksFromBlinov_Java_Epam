package chapter_11.task_A_4;


import java.util.*;
import java.util.concurrent.Semaphore;

public class Runner {


    public static void main(String[] args) {
        LinkedList<Operator> pool = new LinkedList<>();
        pool.add(new Operator("OPERATOR_1"));
        pool.add(new Operator("OPERATOR_2"));
        Semaphore semaphore = new Semaphore(2);
        Client client1 = new Client(semaphore, pool,"client1");
        Client client2 = new Client(semaphore, pool,"client2");
        Client client3 = new Client(semaphore, pool,"client3");
        Client client4 = new Client(semaphore, pool,"client4");
        Client client5 = new Client(semaphore, pool,"client5");
        Client client6 = new Client(semaphore, pool,"client6");
        Client client7 = new Client(semaphore, pool,"client7");
        Client client8 = new Client(semaphore, pool,"client8");
        client1.start();
        client2.start();
        client3.start();
        client4.start();
        client5.start();
        client6.start();
        client7.start();
        client8.start();

        try {
            client1.join();
            client2.join();
            client3.join();
            client4.join();
            client5.join();
            client6.join();
            client7.join();
            client8.join();
        } catch(InterruptedException e) {
            e.printStackTrace();
        }

    }
}

