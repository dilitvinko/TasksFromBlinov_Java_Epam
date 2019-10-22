package onlyTests.threads.ExeptThread;

public class ExceptionThreadDemo {
    public static void main(String[ ] args) throws InterruptedException {
        new ExceptThread().start();
        Thread.sleep(1000);
        boolean flag = true;
        if (flag) {
            throw new RuntimeException();
        }
        System.out.println("end of main");
    }
}
