package chapter_8.task_B_4;

import chapter_8.task_B_4.Entity.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {

        Salad salad = new Salad();
        //salad.addEngridient(cucumber1);
        //System.out.println(salad.kkalIn100gr());

        String filename = "TasksFromBlinov/text/scan.txt";
        Scanner scan = null;
        ArrayList<Integer> mas = new ArrayList<>();
        ArrayList<Boolean> rip = new ArrayList<>();
        try {
            FileReader fr = new FileReader(filename);
            scan = new Scanner(fr);
            // чтение из файла
            while (scan.hasNext()) {
                if (scan.hasNextInt()) {
                    mas.add(scan.nextInt());
                } else if (scan.hasNextBoolean()) {
                    rip.add(scan.nextBoolean());
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println(e);
        } finally {
            if (scan != null) {
                scan.close();
            }
        }

        salad.addEngridient(new Cucumber(mas.get(0), rip.get(0)));
        salad.addEngridient(new Tomato(mas.get(1), rip.get(1)));
        salad.addEngridient(new Potato(mas.get(2), rip.get(2)));
        salad.addEngridient(new Carrot(mas.get(3), rip.get(3)));
        salad.addEngridient(new Bakladzhan(mas.get(4), rip.get(4)));

        System.out.println(salad.kkalIn100gr());

    }
}
