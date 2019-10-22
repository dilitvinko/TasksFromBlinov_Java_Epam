package chapter_10.task_B_13;

import java.util.ArrayList;
import java.lang.Math.*;
import java.util.Collections;
import java.util.PriorityQueue;

public class BigSquare {
    private int xStart;
    private int yStart;
    private PriorityQueue<SmallSquare> cells;

    public BigSquare(double xCircle, double yCircle, double radius) {

        calculateStart(xCircle, yCircle, radius);
        calculateCellsInCircle(xCircle, yCircle, radius);
    }

    private void calculateStart(double xCircle, double yCircle, double radius){
        xStart = (int) ((xCircle - radius) > 0 ? Math.ceil(xCircle - radius) : Math.floor(xCircle - radius));
        yStart = (int) ((yCircle - radius) > 0 ? Math.ceil(yCircle - radius) : Math.floor(yCircle - radius));
    }


    private void calculateCellsInCircle(double xCircle, double yCircle,double radius){
        SmallSquare.setXYCircle(xCircle, yCircle);
        cells = new PriorityQueue<>(new CellsComparator());
        for (int i = yStart; i < yStart + 2 * radius; i++) {
            for (int j = xStart; j < xStart + 2 * radius; j++) {
                if (isInCercle(xCircle, yCircle, radius, j, i)) {
                    cells.add(new SmallSquare(j, i));
                }
            }
        }

        //Collections.sort(cells,new CellsComparator());
    }

    private boolean isInCercle(double xCircle, double yCircle,double radius, int x, int y){
        boolean check = false;
        if (    (Math.pow(x - xCircle,2.0) + Math.pow(y - yCircle, 2.0) < Math.pow(radius, 2.0)) &&
                (Math.pow(x + 1 - xCircle,2.0) + Math.pow(y - yCircle, 2.0) < Math.pow(radius, 2.0)) &&
                (Math.pow(x - xCircle,2.0) + Math.pow(y + 1 - yCircle, 2.0) < Math.pow(radius, 2.0)) &&
                (Math.pow(x + 1 - xCircle,2.0) + Math.pow(y + 1 - yCircle, 2.0) < Math.pow(radius, 2.0))){
            check = true;
        }
        return check;
    }

    public double getxStart() {
        return xStart;
    }

    public void setxStart(int xStart) {
        this.xStart = xStart;
    }

    public double getyStart() {
        return yStart;
    }

    public void setyStart(int yStart) {
        this.yStart = yStart;
    }

    public PriorityQueue<SmallSquare> getCells() {
        return cells;
    }
}
