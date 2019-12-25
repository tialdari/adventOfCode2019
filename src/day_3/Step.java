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

        destinationPoint = new Point(destX, destY, departurePoint.getManhattanValue() + value);
    }

    public boolean isCrossed(Step otherStep){

        if(this.departurePoint.getX() <= otherStep.departurePoint.getX()
                && this.destinationPoint.getX() > otherStep.destinationPoint.getX()
                && this.departurePoint.getY() > otherStep.departurePoint.getY()
                && this.destinationPoint.getY() <= otherStep.destinationPoint.getY()) return true;
        else if(this.departurePoint.getY() <= otherStep.departurePoint.getY()
                && this.destinationPoint.getY() > otherStep.destinationPoint.getY()
                && this.departurePoint.getX() > otherStep.departurePoint.getX()
                && this.destinationPoint.getX() <= otherStep.destinationPoint.getX()) return true;

        return false;
    }

    private int computeCrossPointManhattanValue(Step otherStep, boolean isHorizontal) {
        if (this.departurePoint.getManhattanValue() < otherStep.departurePoint.getManhattanValue()) {
            if ((this.direction.equals("R") || this.direction.equals("L"))) {

                return this.departurePoint.getManhattanValue() + Math.abs(otherStep.destinationPoint.getX() - this.departurePoint.getX());
            } else
                return this.departurePoint.getManhattanValue() + Math.abs(otherStep.destinationPoint.getY() - this.departurePoint.getY());

        } else if (this.departurePoint.getManhattanValue() >= otherStep.departurePoint.getManhattanValue()) {
            if ((otherStep.direction.equals("R") || otherStep.direction.equals("L"))) {

                return otherStep.departurePoint.getManhattanValue() + Math.abs(this.destinationPoint.getX() - otherStep.departurePoint.getX());
            } else
                return otherStep.departurePoint.getManhattanValue() + Math.abs(this.destinationPoint.getY() - otherStep.departurePoint.getY());
        }

        return -1;
    }


//        Point initialPoint;
//
//        if(this.departurePoint.getManhattanValue() < otherStep.departurePoint.getManhattanValue()){
//            initialPoint = this.departurePoint;
//        }
//        else initialPoint = otherStep.departurePoint;
//
//        if(isHorizontal)
//        else return

    public Point generateCrossPoint(Step otherStep){

        if(this.departurePoint.getX() <= otherStep.departurePoint.getX()
                && this.destinationPoint.getX() >= otherStep.destinationPoint.getX()
                && this.departurePoint.getY() >= otherStep.departurePoint.getY()
                && this.destinationPoint.getY() <= otherStep.destinationPoint.getY())
            return new Point(otherStep.departurePoint.getX(), this.destinationPoint.getY(), computeCrossPointManhattanValue(otherStep, true));


        else if(this.departurePoint.getY() <= otherStep.departurePoint.getY()
                && this.destinationPoint.getY() >= otherStep.destinationPoint.getY()
                && this.departurePoint.getX() >= otherStep.departurePoint.getX()
                && this.destinationPoint.getX() <= otherStep.destinationPoint.getX()) return new Point(this.destinationPoint.getX(), otherStep.departurePoint.getY(),
                computeCrossPointManhattanValue(otherStep, false));
        return new Point();
    }

    public String toString(){
        return "departure point: " + departurePoint.toString() + ", destination point: " + destinationPoint.toString()
        + ", direction: " + direction + ", value: " + value;
    }
}
