package chapter_7.task_A_28;

import java.util.regex.Pattern;

public class Runner {

    public static void main(String[] args) {
        String text = "the United Kingdom of Great Britain and Northern Ireland is situated on the British Isles. The British Isles consist of two large islands, Great Britain and Ireland, and above five thousand small islands. Their total area is over 315 000 square kilometers. The United Kingdom is made up of four countries: England, Scotland, Wales and Northern Ireland. Their capitals are London, Edinburgh, Cardiff and Belfast respectively.\n" +
                "\n" +
                "the British isles are separated from the European continent by the North Sea and the English Channel. the western coast of Great Britain is washed by the Atlantic Ocean and the Irish Sea. The surface of the British Isles varies very much. The north of Scotland is mountainous and is called Highlands, while the south, which has beautiful valleys and plains, is called Lowlands. The north and west of England are mountainous, but all the rest - east, center and southeast - is a vast plain. mountains are not very high. Ben Nevis is the highest mountain. (1343 m.)\n" +
                "\n" +
                "there are a lot of rivers in GB, but they are not very long. The Severn is the longest river, while the Thames is the deepest and the most important one.\n" +
                "\n" +
                "the UK is one of the world’s smallest countries. The population of the country is over 87 million and about 80% of it is urban. The UK is highly developed industrial country. It’s known as one of world’s largest producers and exporters of machinery, electronics, textile, aircraft and navigation equipment. The UK is constitutional monarchy. In law, the Head of State is the Queen, but in practice, the Queen reigns, but does not rule. The country is ruled by the elected government with the Prime Minister at the head. the British Parliament consists of two chambers: the House of Lords and the House of Commons.\n" +
                "\n" +
                "there are three main political parties in Great Britain: the Labour, the Conservative and the Liberal parties. the Liberal party is the ruling party nowadays.";


        String tmpText = text.toLowerCase();


        Pattern pattern = Pattern.compile("\\.");
        String[ ] sentenses = pattern.split(tmpText);
        String res = "";
        for (int i = 0; i < sentenses.length ; i++) {
            if (Character.isLetter(sentenses[i].charAt(0))) {
                res += sentenses[i].substring(0, 1).toUpperCase() + sentenses[i].substring(1) + ". ";
            }else {
                if (Character.isLetter(sentenses[i].charAt(1))) {
                    res += sentenses[i].substring(1, 2).toUpperCase() + sentenses[i].substring(2) + ". ";
                }
            }

                //System.out.println(sentenses[i]);

        }
        System.out.println(res);


//        String[] strs = {"abcd efjk", "hello worlde", "a", "E", "d", "", "\n", "юникод"};
//        for (String str: strs) {
//            boolean test = str.matches(".*(?i:[aeiouy])");
//            System.out.println(str + ": " + test);
//        }

//        Pattern pattern = Pattern.compile("[^а-яА-я]");
//        String[ ] words = pattern.split(poem);
//        for (int i = 0; i < words.length ; i++) {
//            if (words[i].matches(".*(?i:[уеыаоэяию])" )){
//                System.out.println(words[i]);
//            }
//        }

    }

}
