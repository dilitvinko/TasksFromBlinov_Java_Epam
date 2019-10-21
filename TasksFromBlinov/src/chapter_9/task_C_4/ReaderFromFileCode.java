package chapter_9.task_C_4;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ReaderFromFileCode {
    private static String codeText;

    public static void readCode(String nameFile){


        Path ph = Path.of("TasksFromBlinov/text/"+ nameFile);
        codeText = "";
        try{
            codeText = Files.readString(ph );
        }catch (IOException e){
            System.err.println(e.getMessage());
        }

    }

    public static void replaceUpper(){

        String words[] = codeText.split("\\W+");

        for (int i = 0; i < words.length; i++) {
            if (words[i].length() > 2){
                codeText = codeText.replace(words[i], words[i].toUpperCase());
            }
        }

        System.out.println(codeText);
    }

    public static String getCodeText() {
        return codeText;
    }


}
