package chapter_10.task_B_13;

public class SmallSquare {
    private int x;
    private int y;
    private static double xCircle;
    private static double yCircle;

    public SmallSquare(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public SmallSquare(SmallSquare ss) {
        this.x = ss.x;
        this.y = ss.y;
    }

    public static double getxCircle() {
        return xCircle;
    }

    public static double getyCircle() {
        return yCircle;
    }

    public static void setXYCircle(double xC, double yC){
        xCircle = xC;
        yCircle = yC;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "x= " + x +"  y= " + y;
    }
}
