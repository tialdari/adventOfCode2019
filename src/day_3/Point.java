package day_3;

import java.util.Comparator;

public class Point {

    private final int initialX = 0;
    private final int initialY = 0;
    private int x;
    private int y;
    private int manhattanValue;
    private int stepsNum;

    public Point() {
        x = 0;
        y = 0;
        manhattanValue = 0;
        stepsNum = 0;
    }

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
        manhattanValue = 0;
    }

    public Point(int x, int y, int stepsNum) {
        this.x = x;
        this.y = y;
        manhattanValue = 0;
        this.stepsNum = stepsNum;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getManhattanValue() {
        return manhattanValue;
    }

    public int getStepsNum() {
        return stepsNum;
    }

    public void setStepsNum(int stepsNum) {
        this.stepsNum = stepsNum;
    }

    public void computeManhattanValue(){

        manhattanValue = Math.abs(x - initialX) + Math.abs(y - initialY);
    }

    public String toString(){
        return "x: " + x + ", y: " + y +", manhattanValue: " + manhattanValue;
    }

    public static class PointsComparator implements Comparator<Point>
    {
        public int compare(Point a, Point b)
        {
            return a.getManhattanValue() -(b.getManhattanValue());
        }
    }

    public static class StepsComparator implements Comparator<Point>
    {
        public int compare(Point a, Point b)
        {
            return a.getStepsNum() -(b.getStepsNum());
        }
    }

    public int countSteps(Point point){

        if(point.x == this.x){
            return stepsNum + Math.abs(point.y - this.y);
        }else if (point.y == this.y){
            return stepsNum + Math.abs(point.x - this.x);
        }
        return 0;
    }
}
