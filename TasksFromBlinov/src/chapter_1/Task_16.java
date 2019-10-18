package chapter_1;

import java.util.Scanner;



public class Task_16 {

    public static long fact(int number) {
        long result = 1;

        for (int factor = 2; factor <= number; factor++) {
            result *= factor;
        }

        return result;
    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.println("Write n");
        int n = in.nextInt();

        int res;

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= i; j++) {
                res = (int) (fact(i) / (fact(j) * fact(i - j)));
                System.out.print(res + " ");
            }
            System.out.println();
        }

    }
}
