package chapter_6.task_5;

import java.util.ArrayList;

public abstract class SiemensMobile implements Mobile {
    private ArrayList<String> contacts;
    private boolean isLock = true;


    @Override
    public void ring() {
        System.out.println("ring-ring-ring!!!");
    }

    @Override
    public void call(String str) {
        System.out.println("Out call to " + str + "\n");
    }

    @Override
    public String getAllContact() {
        String temp = "";
        for (String cont :  contacts) {
            temp += cont;
        }
        return temp;
    }

    public boolean isLock() {
        return isLock;
    }

    public void setLock(boolean lock) {
        isLock = lock;
    }
}
