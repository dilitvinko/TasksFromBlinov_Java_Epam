package chapter_9.task_C_4;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriterInFileNewCode {
    public static void writeCode(String dir, String nameFile, String codeText){
        File newDir = new File("D:/Projects/TasksBlinov/TasksFromBlinov/" + File.separator + dir);
        File newFile;


        try
        {
            newDir.mkdirs();
            newFile = new File(newDir.getCanonicalPath() + File.separator + nameFile);
            FileWriter fw = new FileWriter(newFile, false);
            boolean created = newFile.createNewFile();
            fw.write(codeText);
            if(created)
                System.out.println("File has been created");

            fw.flush();
        }
        catch(IOException ex){

            System.err.println(ex.getMessage());
        }

    }
}
