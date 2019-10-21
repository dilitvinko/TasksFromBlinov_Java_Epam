package chapter_9.task_A_5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Runner {

    public static void main(String[] args) {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("TasksFromBlinov/text/forChapter_9.txt"));
            String tmp;
            while ((tmp = br.readLine()) != null) {
               System.out.println(maxNumInLine(tmp));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }



    }

    private static String maxNumInLine(String str){
        String res = "";
        StringBuilder tmp = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) <= '9' && str.charAt(i) >= '0'){
                tmp.append(str.charAt(i));

            }else{
                if (tmp.length() > res.length()){
                    res = tmp.toString();
                }
                tmp = new StringBuilder();
            }
        }

        return res + " --> " + res.length();
    }

}
