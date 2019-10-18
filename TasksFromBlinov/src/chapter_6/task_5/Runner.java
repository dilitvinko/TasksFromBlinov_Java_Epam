package chapter_6.task_5;

public class Runner {
    public static void main(String[] args) {
        SiemensMobile mobile1 = new Model("CooliPhone");
        mobile1.call("12321344");
        mobile1.unlock();
        mobile1.call("12321344");
        mobile1.ring();
    }


}
