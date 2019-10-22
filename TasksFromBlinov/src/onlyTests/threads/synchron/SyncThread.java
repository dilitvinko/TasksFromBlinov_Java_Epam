package onlyTests.threads.synchron;

public class SyncThread extends Thread {
    private Resource rs;
    public SyncThread(String name, Resource rs) {
        super(name);
        this.rs = rs;
    }
    public void run() {
        rs.writing("\n", 000);
        for (int i = 0; i < 5; i++) {
            rs.writing(getName(), i); // место срабатывания синхронизации
        }
    }
}
