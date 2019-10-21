package chapter_8.task_B_4.Exeptions;

public class ArgumentExeption extends RuntimeException {
    public ArgumentExeption() {
    }

    public ArgumentExeption(String message) {
        super(message);
    }
}
