package chapter_11.task_A_4;

import java.util.LinkedList;
import java.util.concurrent.Semaphore;

public class Client extends Thread {
    private Semaphore semaphore;
    private LinkedList<Operator> pool;
    private String name;
    public Client(Semaphore semaphore, LinkedList<Operator> pool, String nameClient) {
        this.semaphore = semaphore;
        this.pool = pool;
        this.name = nameClient;
    }

    private boolean want = true;
    private boolean wantToWaitOnTheLine;

    {
        if(this.getTimeWait()%2 == 0)
            wantToWaitOnTheLine = true;
    }
    public void run() {
        Operator operator = null;
        try {
            while(want) {
                // занять семафор
                if (semaphore.tryAcquire()) {
                    // выкачать одного оператора
                    operator = pool.removeFirst();
                    operator.speak(name);
                    // для наглядности
                    Thread.sleep(5000);
                    this.speakToOperator(operator.getName());
                    want = false;
                } else if(wantToWaitOnTheLine) {
                    // можно добавть flag чтобы сообщение об ожидании отработало один раз
                    //System.out.println(name + " will wait on the line!" );
                } else { // если не удалось занять семафор
                    // решает перезвонить через random-ноe время
                    int timeWait = getTimeWait();
                    System.out.println(name + " is trying to call after "+ timeWait+"!" );
                    Thread.sleep(timeWait);
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            if(operator != null)
                pool.add(operator);
            // освободить семафор
            semaphore.release();
            // завершаем работу потока-клиента
            return;
        }
    }

    protected void speakToOperator(String nameOperator) {
        System.out.println(name + " end speaking with " + nameOperator);
    }

    private int getTimeWait() {
        return (int)(Math.random()*5000+1);
    }
}
