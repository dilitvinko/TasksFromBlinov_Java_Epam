package chapter_10.task_A_6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Runner {
    public static void main(String[] args) {
        String poem = "Буря мглою небо кроет,\n" +
                "Вихри снежные крутя;\n" +
                "То, как зверь, она завоет,\n" +
                "То заплачет, как дитя,\n" +
                "То по кровле обветшалой\n" +
                "Вдруг соломой зашумит,\n" +
                "То, как путник запоздалый,\n" +
                "К нам в окошко застучит.\n" +
                "Наша ветхая лачужка\n" +
                "И печальна и темна.\n" +
                "Что же ты, моя старушка,\n" +
                "Приумолкла у окна?\n" +
                "Или бури завываньем\n" +
                "Ты, мой друг, утомлена,\n" +
                "Или дремлешь под жужжаньем\n" +
                "Своего веретена?";
        String[] lines = poem.split("\n");
        ArrayList<String> arrLines = new ArrayList<>(Arrays.asList(lines));
        Collections.sort(arrLines, new myComparator());
        for (String line : arrLines){
            System.out.println(line);
        }
    }
}


class myComparator implements Comparator<String>{
    @Override
    public int compare(String o1, String o2) {
        return o1.length() - o2.length();
    }
}
