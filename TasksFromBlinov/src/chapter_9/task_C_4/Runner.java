package chapter_9.task_C_4;

import java.io.File;
import java.io.IOException;

public class Runner {
    public static void main(String[] args) {

        ReaderFromFileCode.readCode("forChapter_9_task_C_4.txt");
        ReaderFromFileCode.replaceUpper();
        WriterInFileNewCode.writeCode("text/directoryFromCh_9/", "task_C_4.txt", ReaderFromFileCode.getCodeText());

    }
}
