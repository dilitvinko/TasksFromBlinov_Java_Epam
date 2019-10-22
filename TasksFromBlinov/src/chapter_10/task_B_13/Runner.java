package chapter_10.task_B_13;

public class Runner {
    public static void main(String[] args) {
        double xCircle = 3;
        double yCircle = 4;
        double radius = 5;

        BigSquare bigSquare = new BigSquare(xCircle, yCircle, radius);
        System.out.println(Math.ceil(-5.6));
        double a1 = (xCircle - radius) > 0 ? Math.ceil(xCircle - radius) : Math.floor(xCircle - radius);
        double a2 = (yCircle - radius) > 0 ? Math.ceil(yCircle - radius) : Math.floor(yCircle - radius);
        System.out.println( a1 + " " + a2 );
        for (SmallSquare ss : bigSquare.getCells()) {
            System.out.println(ss);
        }
        System.out.println(SmallSquare.getxCircle() + " " + SmallSquare.getyCircle());

    }
}
