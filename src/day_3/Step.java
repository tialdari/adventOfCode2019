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

    public Point getDestinationPoint() {
        return destinationPoint;
    }

    public void computeDestinationPoint() {

        int destX = departurePoint.getX();
        int destY = departurePoint.getY();

        switch (direction) {
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

        destinationPoint = new Point(destX, destY, departurePoint.getStepsNum() + value);
        destinationPoint.computeManhattanValue();
    }

    public boolean isCrossed(Step otherStep) {

        if (this.direction != otherStep.direction) {

            if (this.direction.equals("U") || this.direction.equals("D")) {
                // Check if the first line is in horizontal range of the second line and
                // if the second line is in vertical range of the first line
                if (((this.departurePoint.getX() >= otherStep.departurePoint.getX() && this.departurePoint.getX() <= otherStep.destinationPoint.getX())
                        || ((this.departurePoint.getX() <= otherStep.departurePoint.getX() && this.departurePoint.getX() >= otherStep.destinationPoint.getX())))
                        && ((otherStep.departurePoint.getY() >= this.departurePoint.getY() && otherStep.departurePoint.getY() <= this.destinationPoint.getY())
                        || (otherStep.departurePoint.getY() <= this.departurePoint.getY() && otherStep.departurePoint.getY() >= this.destinationPoint.getY())))
                    return true;
            } else {
                // Check if the first line is in vertical range of the second line and
                // if the second line is in horizontal range of the first line
                if (((this.departurePoint.getY() >= otherStep.departurePoint.getY() && this.departurePoint.getY() <= otherStep.destinationPoint.getY())
                        || (this.departurePoint.getY() <= otherStep.departurePoint.getY() && this.departurePoint.getY() >= otherStep.destinationPoint.getY()))
                        && ((otherStep.departurePoint.getX() >= this.departurePoint.getX() && otherStep.departurePoint.getX() <= this.destinationPoint.getX())
                        || (otherStep.departurePoint.getX() <= this.departurePoint.getX() && otherStep.departurePoint.getX() >= this.destinationPoint.getX())))
                    return true;
            }
        }

        return false;
    }

    public Point generateCrossPoint(Step otherStep) {

        int thisStepStepsNum;
        int otherStepStepsNum;
        Point newCrossPoint;

        if (isCrossed(otherStep)) {
            if (this.direction.equals("U") || this.direction.equals("D")) {

                newCrossPoint = new Point(this.departurePoint.getX(), otherStep.destinationPoint.getY());
                thisStepStepsNum = this.departurePoint.countSteps(newCrossPoint);
                otherStepStepsNum = otherStep.departurePoint.countSteps(newCrossPoint);
                newCrossPoint.setStepsNum(thisStepStepsNum + otherStepStepsNum);
                return newCrossPoint;

            } else if (this.direction.equals("R") || this.direction.equals("L")) {

                newCrossPoint = new Point(otherStep.destinationPoint.getX(), this.departurePoint.getY());
                thisStepStepsNum = this.departurePoint.countSteps(newCrossPoint);
                otherStepStepsNum = otherStep.departurePoint.countSteps(newCrossPoint);
                newCrossPoint.setStepsNum(thisStepStepsNum + otherStepStepsNum);
                return newCrossPoint;
            }
        }
        return null;
    }

    public String toString() {
        return "departure point: " + departurePoint.toString() + ", destination point: " + destinationPoint.toString()
                + ", direction: " + direction + ", value: " + value;
    }
}
