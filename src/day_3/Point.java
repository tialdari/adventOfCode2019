package day_3;

public class Point {

    private int x;
    private int y;
    private int manhattanValue;

    public Point() {
        x = 0;
        y = 0;
        manhattanValue = 0;
    }

    public Point(int x, int y, int manhattanValue ) {
        this.x = x;
        this.y = y;
        this.manhattanValue = manhattanValue;
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

    public String toString(){
        return "x: " + x + ", y: " + y +", manhattanValue: " + manhattanValue;
    }
}
