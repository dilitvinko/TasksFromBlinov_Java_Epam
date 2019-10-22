package chapter_10.task_B_13;

import java.util.Comparator;

public class CellsComparator implements Comparator<SmallSquare> {
    @Override
    public int compare(SmallSquare o1, SmallSquare o2) {
        double xCentr1 = (double)o1.getX() + 0.5;
        double yCentr1 = (double)o1.getY() + 0.5;
        double xCentr2 = (double)o2.getX() + 0.5;
        double yCentr2 = (double)o2.getY() + 0.5;
        double dist1 = Math.pow(xCentr1 - SmallSquare.getxCircle(),2) + Math.pow(yCentr1 - SmallSquare.getyCircle(),2);
        double dist2 = Math.pow(xCentr2 - SmallSquare.getxCircle(),2) + Math.pow(yCentr2 - SmallSquare.getyCircle(),2);
        if (dist1 - dist2 < 0 )
            return -1;
        else if (dist1 - dist2 > 0)
            return 1;
        else
            return 0;
    }
}
