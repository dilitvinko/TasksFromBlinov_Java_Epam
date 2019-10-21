package chapter_7.task_A_12;

import java.util.regex.Pattern;

public class Runner {
    public static void main(String[] args) {
        String poem = "Последняя туча рассеянной бури!\n" +
                "Одна ты несешься по ясной лазури,\n" +
                "Одна ты наводишь унылую тень,\n" +
                "Одна ты печалишь ликующий день.\n" +
                "\n" +
                "Ты небо недавно кругом облегала,\n" +
                "И молния грозно тебя обвивала;\n" +
                "И ты издавала таинственный гром\n" +
                "И алчную землю поила дождем.";

        String[] strs = {"abcd efjk", "hello worlde", "a", "E", "d", "", "\n", "юникод"};
        for (String str: strs) {
            boolean test = str.matches(".*(?i:[aeiouy])");
            System.out.println(str + ": " + test);
        }

        Pattern pattern = Pattern.compile("[^а-яА-я]");
        String[ ] words = pattern.split(poem);
        for (int i = 0; i < words.length ; i++) {
            if (words[i].matches(".*(?i:[уеыаоэяию])" )){
                System.out.println(words[i]);
            }
        }

    }
}
