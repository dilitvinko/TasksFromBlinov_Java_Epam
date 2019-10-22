package chapter_11.task_A_4;

public class Operator {

    private String name;

    public Operator(String name) {
        this.name = name;
    }

    public void speak(String nameClient) {
        System.out.println(name + " start talk with " + nameClient);
    }

    public String getName() {
        return name;
    }
}
