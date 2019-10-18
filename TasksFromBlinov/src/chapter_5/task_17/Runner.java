package chapter_5.task_17;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Arrays;

public class Runner {
    public static void main(String[] args) {
        Cinema cinema1 = new Cinema("Moskva");
        cinema1.addSeans("qwe","boevik",144, LocalTime.of(12,30));
        cinema1.addSeans("asd","roman",120, LocalTime.of(14,30));
        cinema1.addSeans("qwe","boevik",144, LocalTime.of(17,30));
        cinema1.addSeans("qwe","boevik",144, LocalTime.of(19,30));
        Cinema cinema2 = new Cinema("Oktyabr");
        cinema2.addSeans("asd","roman",120, LocalTime.of(12,30));
        cinema2.addSeans("asd","roman",120, LocalTime.of(15,30));
        cinema2.addSeans("qwe","boevik",144, LocalTime.of(18,30));
        cinema2.addSeans("qwe","boevik",144, LocalTime.of(20,30));
        Cinema cinema3 = new Cinema("Salyut");
        cinema3.addSeans("qwe","boevik",144, LocalTime.of(15,30));
        cinema3.addSeans("asd","roman",120, LocalTime.of(17,00));
        cinema3.addSeans("qwe","boevik",144, LocalTime.of(21,00));
        System.out.println(cinema1);
        System.out.println(cinema2);
        System.out.println(cinema3);
    }
}
