package onlyTests.threads.ExeptThread;

public class ExceptThread extends Thread {
    public void run() {
        try {
            Thread.sleep(1000);
        }catch (InterruptedException e){
            System.err.println(e.getMessage());
        }

        System.out.println("end of ExceptThread");
    }
}
