package chapter_11.task_A_4_bad;

import java.util.LinkedList;

public class RunnerCallCentre {
    public static void main(String[] args) {
        LinkedList<Client> clients = new LinkedList<>(){{
            add(new Client(1,1600, 500));
            add(new Client(2,2000, 2000));
            add(new Client(3,800, 1500));
            add(new Client(4,3000, 7000));
            add(new Client(5,1500, 3000));
        }};

        for (Client cl : clients) {
            cl.start();
        }

        //clients.remove(new Client(1,1600, 2000));

        Operator operator = new Operator(new WaitQueue(clients));

        operator.start();

//        System.out.println(1);
//
//        Client client1 = new Client(6, 7, 5);
//        Client client = new Client(6, 7, 5);
//        try {
//            System.out.println(2);
//            client1.start();
//            client1.join(20000);
//            System.out.println(3);
//        }catch (InterruptedException ie){
//            System.err.println(ie.getMessage());
//        }
//        System.out.println(4);


    }
}
