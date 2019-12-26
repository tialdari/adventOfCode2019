package day_3;

public class Step {

    private Point departurePoint;
    private Point destinationPoint;
    private String direction;
    private int value;

    private static final String UP_SIGNATURE = "U";
    private static final String DOWN_SIGNATURE = "D";
    private static final String LEFT_SIGNATURE = "L";
    private static final String RIGHT_SIGNATURE = "R";

    public Step(final Point departurePoint, String direction, int value) {
        this.departurePoint = departurePoint;
        this.direction = direction;
        this.value = value;
        destinationPoint = new Point();
    }

    public Step(final Point departurePoint, final Point destinationPoint, String direction, int value) {
        this.departurePoint = departurePoint;
        this.direction = direction;
        this.value = value;
        this.destinationPoint = destinationPoint;
    }

    public Point getDestinationPoint() {
        return destinationPoint;
    }

    public void setDestinationPoint(Point destinationPoint) {
        this.destinationPoint = destinationPoint;
    }

    public void computeDestinationPoint(){

        int destX = departurePoint.getX();
        int destY = departurePoint.getY();

        switch(direction){
            case UP_SIGNATURE:
                destY += value;
                break;
            case DOWN_SIGNATURE:
                destY -= value;
                break;
            case LEFT_SIGNATURE:
                destX -= value;
                break;
            case RIGHT_SIGNATURE:
                destX += value;
                break;
        }

        destinationPoint = new Point(destX, destY);
        destinationPoint.computeManhattanValue();
    }

    public boolean isCrossed(Step otherStep){

        Point p1, p_1, p2, p_2;
        p1 = this.departurePoint;
        p_1 = this.destinationPoint;
        p2 = otherStep.departurePoint;
        p_2 = otherStep.destinationPoint;

        if (this.direction != otherStep.direction) {

            if (this.direction == "R" || this.direction == "L") {

                if(case1(p1, p_1, p2, p_2) == true || case2(p1, p_1, p2, p_2) == true
                || case3(p1, p_1, p2, p_2) == true || case4(p1, p_1, p2, p_2) == true) return true;

            } else {
                if(case5(p1, p_1, p2, p_2) == true || case6(p1, p_1, p2, p_2) == true
                || case7(p1, p_1, p2, p_2) == true || case8(p1, p_1, p2, p_2) == true) return true;
            }
        }

        return false;
    }

    private boolean case1(Point p1, Point p_1, Point p2, Point p_2){

        if(p1.getX() <= p2.getX() && p_1.getX() >= p2.getX()
        && p2.getY() <= p1.getY() && p_2.getY() >= p1.getY()) return true;
        return false;
    }

    private boolean case2(Point p1, Point p_1, Point p2, Point p_2){

        if(p1.getX() >= p2.getX() && p_1.getX() <= p2.getX()
        && p2.getY() <= p1.getY() && p_2.getY() >= p1.getY()) return true;
        return false;

    }

    private boolean case3(Point p1, Point p_1, Point p2, Point p_2){

        if(p1.getX() <= p2.getX() && p_1.getX() >= p2.getX()
        && p2.getY() >= p1.getY() && p_2.getY() <= p1.getY()) return true;
        return false;

    }

    private boolean case4(Point p1, Point p_1, Point p2, Point p_2){

        if(p1.getX() >= p2.getX() && p_1.getX() <= p2.getX()
        && p2.getY() >= p1.getY() && p_2.getY() <= p1.getY()) return true;
        return false;
    }

    private boolean case5(Point p1, Point p_1, Point p2, Point p_2){

        if(p2.getX() <= p1.getX() && p_2.getX() >= p1.getX()
                && p1.getY() <= p2.getY() && p_1.getY() >= p2.getY()) return true;
        return false;

    }

    private boolean case6(Point p1, Point p_1, Point p2, Point p_2){

        if(p2.getX() >= p1.getX() && p_2.getX() <= p1.getX()
                && p1.getY() <= p2.getY() && p_1.getY() >= p2.getY()) return true;
        return false;
    }

    private boolean case7(Point p1, Point p_1, Point p2, Point p_2){

        if(p2.getX() <= p1.getX() && p_2.getX() >= p1.getX()
                && p1.getY() >= p2.getY() && p_1.getY() <= p2.getY()) return true;
        return false;
    }

    private boolean case8(Point p1, Point p_1, Point p2, Point p_2){

        if(p2.getX() >= p1.getX() && p_2.getX() <= p1.getX()
                && p1.getY() >= p2.getY() && p_1.getY() <= p2.getY()) return true;
        return false;
    }

    public Point generateCrossPoint(Step otherStep){

        if (isCrossed(otherStep)) {
            if (this.direction == "U" || this.direction == "D") {
                return new Point(this.departurePoint.getX(), otherStep.destinationPoint.getY());
            } else {
                return new Point(otherStep.destinationPoint.getX(), this.departurePoint.getY());
            }
        }

        return null;
    }

    public String toString(){
        return "departure point: " + departurePoint.toString() + ", destination point: " + destinationPoint.toString()
        + ", direction: " + direction + ", value: " + value;
    }
}
